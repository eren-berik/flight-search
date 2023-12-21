package com.erenberik.flightsearchapi.service;

import com.erenberik.flightsearchapi.model.Flight;
import com.erenberik.flightsearchapi.dto.FlightDto;

import java.util.List;

public interface FlightService {
    FlightDto createFlight(Flight flight);
    FlightDto getFlightById(int id);
    List<FlightDto> getAllFlights();
    FlightDto updateFlight(Flight flight, int id);
    void deleteFlightById(int id);
}
