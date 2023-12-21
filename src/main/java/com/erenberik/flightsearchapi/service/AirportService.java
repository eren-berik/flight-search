package com.erenberik.flightsearchapi.service;

import com.erenberik.flightsearchapi.dto.AirportDto;
import com.erenberik.flightsearchapi.model.Airport;

import java.util.List;

public interface AirportService {
    AirportDto createAirport(Airport airport);

    AirportDto getAirportById(int id);

    /*List<AirportDto> getAllAirports();
    AirportDto getAirportById(int id);
    AirportDto updateAirport(AirportDto airportDto, int id);
    void deleteAirport(int id);*/
}
