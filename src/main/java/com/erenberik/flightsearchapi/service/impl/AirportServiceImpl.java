package com.erenberik.flightsearchapi.service.impl;

import com.erenberik.flightsearchapi.dto.AirportDto;
import com.erenberik.flightsearchapi.exception.FlightNotFoundException;
import com.erenberik.flightsearchapi.model.Airport;
import com.erenberik.flightsearchapi.repository.AirportRepository;
import com.erenberik.flightsearchapi.mapper.AirportMapper;
import com.erenberik.flightsearchapi.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AirportServiceImpl implements AirportService {
    private final AirportRepository airportRepository;

    @Autowired
    public AirportServiceImpl(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    @Override
    public AirportDto createAirport(Airport airport) {
        Airport newAirport = airportRepository.save(airport);

        return AirportMapper.mapToDto(newAirport);
    }

    @Override
    public AirportDto getAirportById(int id) {
        Airport airport = airportRepository.findById(id).orElseThrow(()-> new FlightNotFoundException("Flight could not be found!"));

        return AirportMapper.mapToDto(airport);
    }

    @Override
    public List<AirportDto> getAllAirports() {
        List<Airport> airport = airportRepository.findAll();

        List<AirportDto> airportDtoList = airport.stream()
                .map(AirportMapper::mapToDto)
                .collect(Collectors.toList());

        return airportDtoList;
    }
}
