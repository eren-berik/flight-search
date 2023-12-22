package com.erenberik.flightsearchapi.service.impl;

import com.erenberik.flightsearchapi.dto.AirportCreateReqDTO;
import com.erenberik.flightsearchapi.dto.AirportResDTO;
import com.erenberik.flightsearchapi.dto.AirportUpdateReqDTO;
import com.erenberik.flightsearchapi.exception.AirportNotFoundException;
import com.erenberik.flightsearchapi.exception.AlreadyExistsException;
import com.erenberik.flightsearchapi.exception.BaseErrorMsg;
import com.erenberik.flightsearchapi.exception.errors.AirportErrors;
import com.erenberik.flightsearchapi.model.Airport;
import com.erenberik.flightsearchapi.repository.AirportRepository;
import com.erenberik.flightsearchapi.mapper.AirportMapper;
import com.erenberik.flightsearchapi.service.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AirportServiceImpl implements AirportService {

    private final AirportRepository airportRepository;
    private final AirportMapper airportMapper;

    @Override
    public AirportResDTO createAirport(AirportCreateReqDTO airportCreateReqDTO) {

        String airportName = airportCreateReqDTO.getName();
        Integer cityCode = airportCreateReqDTO.getCityCode();

        if (isAirportExist(airportName, cityCode)) {
            throw new AlreadyExistsException(AirportErrors.ALREADY_IN_USE);
        }

        Airport airport = airportMapper.mapToAirport(airportCreateReqDTO);

        airport = airportRepository.save(airport);

        return airportMapper.mapToAirportResponseDTO(airport);
    }

    @Override
    public Airport getAirportById(Long id) {
        return airportRepository.findById(id)
                .orElseThrow(() -> new AirportNotFoundException("Airport not found!"));
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
    public AirportResDTO updateAirport(AirportUpdateReqDTO airportUpdateReqDTO, Long id) {
        //todo: Need to check if that airport exist in DB if not proceed
        Airport airport = airportMapper.mapToAirport(airportUpdateReqDTO);
        airport = airportRepository.save(airport);

        return airportMapper.mapToAirportResponseDTO(airport);
    }

    @Override
    public void deleteAirport(Long id) {
        Airport airport = airportRepository.findById(id).orElseThrow(() -> new AirportNotFoundException("Airport could not be found!"));
        airportRepository.delete(airport);
    }

    private boolean isAirportExist(String airportName, Integer cityCode) {
        return airportRepository.existsAirportByAirportNameAndCityCode(airportName, cityCode);
    }
}
