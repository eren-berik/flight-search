package com.erenberik.flightsearchapi.service;

import com.erenberik.flightsearchapi.dto.FlightCreateReqDTO;
import com.erenberik.flightsearchapi.dto.FlightResDTO;
import com.erenberik.flightsearchapi.dto.FlightUpdateReqDTO;
import com.erenberik.flightsearchapi.model.Flight;

import java.util.List;

public interface FlightService {
    FlightResDTO createFlight(FlightCreateReqDTO flightCreateReqDTO);
    List<FlightResDTO> getAllFlights();
    FlightResDTO getFlightById(Long id);
    FlightResDTO updateFlight(FlightUpdateReqDTO flightUpdateReqDTO, Long id);
    void deleteFlightById(Long id);
}
