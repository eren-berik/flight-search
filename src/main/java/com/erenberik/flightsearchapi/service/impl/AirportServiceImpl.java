package com.erenberik.flightsearchapi.service.impl;

import com.erenberik.flightsearchapi.dto.AirportDto;
import com.erenberik.flightsearchapi.model.Airport;
import com.erenberik.flightsearchapi.repository.AirportRepository;
import com.erenberik.flightsearchapi.mapper.AirportMapper;
import com.erenberik.flightsearchapi.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
