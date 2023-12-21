package com.erenberik.flightsearchapi.mapper;

import com.erenberik.flightsearchapi.dto.AirportDto;
import com.erenberik.flightsearchapi.model.Airport;

public class AirportMapper {
    public static AirportDto mapToDto(Airport airport) {
        AirportDto airportDto = new AirportDto();
        airportDto.setId(airport.getId());
        airportDto.setCity(airport.getCity());

        return airportDto;
    }
}
