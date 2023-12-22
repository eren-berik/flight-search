package com.erenberik.flightsearchapi.service.impl;

import com.erenberik.flightsearchapi.dto.AirportCreateReqDTO;
import com.erenberik.flightsearchapi.dto.AirportResDTO;
import com.erenberik.flightsearchapi.dto.AirportUpdateReqDTO;
import com.erenberik.flightsearchapi.exception.AlreadyExistsException;
import com.erenberik.flightsearchapi.exception.NotFoundException;
import com.erenberik.flightsearchapi.exception.errors.AirportErrors;
import com.erenberik.flightsearchapi.model.Airport;
import com.erenberik.flightsearchapi.repository.AirportRepository;
import com.erenberik.flightsearchapi.mapper.AirportMapper;
import com.erenberik.flightsearchapi.service.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AirportServiceImpl implements AirportService {

    private final AirportRepository airportRepository;
    private final AirportMapper airportMapper;

    @Override
    public AirportResDTO createAirport(AirportCreateReqDTO airportCreateReqDTO) {

        String name = airportCreateReqDTO.getName();
        Integer cityCode = airportCreateReqDTO.getCityCode();

        if (isAirportExist(name, cityCode)) {
            throw new AlreadyExistsException(AirportErrors.ALREADY_IN_USE);
        }

        Airport airport = airportMapper.mapToAirport(airportCreateReqDTO);
        airport = airportRepository.save(airport);

        return airportMapper.mapToAirportResponseDTO(airport);
    }

    @Override
    public Airport getAirportById(Long id) {
        return airportRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(AirportErrors.AIRPORT_NOT_FOUND));
    }

    @Override
    public List<AirportResDTO> getAllAirports() {
        Sort sort = Sort.by("city.cityCode");

        List<Airport> airport = airportRepository.findAll();

        List<AirportResDTO> airportDtoList = airport.stream()
                .map(airportMapper::mapToAirportResponseDTO)
                .collect(Collectors.toList());

        return airportDtoList;
    }

    @Override
    public AirportResDTO updateAirport(AirportUpdateReqDTO airportUpdateReqDTO, @PathVariable Long id) {

        if (!isExistsById(id)) {
            throw new AlreadyExistsException(AirportErrors.AIRPORT_NOT_FOUND);
        }

        Airport airport = airportMapper.mapToAirport(airportUpdateReqDTO);
        airport = airportRepository.save(airport);

        return airportMapper.mapToAirportResponseDTO(airport);
    }

    @Override
    public void deleteAirport(Long id) {

        if (!isExistsById(id)) {
            throw new AlreadyExistsException(AirportErrors.AIRPORT_NOT_FOUND);
        }

        airportRepository.deleteById(id);
    }

    //Helper methods
    private boolean isAirportExist(String name, Integer cityCode) {
        return airportRepository.existsByNameAndCity_CityCode(name, cityCode);
    }

    private boolean isExistsById(Long id) {
        return airportRepository.existsById(id);
    }
}
