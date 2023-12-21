package com.erenberik.flightsearchapi.mapper;

import com.erenberik.flightsearchapi.dto.FlightDto;
import com.erenberik.flightsearchapi.model.Flight;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class FlightMapper {
    public static FlightDto mapToDto(Flight flight) {
        FlightDto flightDto = new FlightDto();
        flightDto.setId(flight.getId());
        flightDto.setDepartureAirport(flight.getDepartureAirport());
        flightDto.setArrivalAirport(flight.getArrivalAirport());
        flightDto.setDepartureTime(flight.getDepartureTime());
        flightDto.setArrivalTime(flight.getArrivalTime());
        flightDto.setPrice(flight.getPrice());
        return flightDto;
    }
}
