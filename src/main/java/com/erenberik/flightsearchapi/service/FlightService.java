package com.erenberik.flightsearchapi.service;

import com.erenberik.flightsearchapi.dto.FlightCreateReqDTO;
import com.erenberik.flightsearchapi.dto.FlightResDTO;
import com.erenberik.flightsearchapi.dto.FlightUpdateReqDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface FlightService {
    FlightResDTO createFlight(FlightCreateReqDTO flightCreateReqDTO);
    List<FlightResDTO> getAllFlights();
    FlightResDTO getFlightById(Long id);
    FlightResDTO updateFlight(FlightUpdateReqDTO flightUpdateReqDTO, Long id);
    void deleteFlightById(Long id);
    List<FlightResDTO> findByDepartureAirportIdAndArrivalAirportIdAndDepartureTime(Long departureAirportId, Long arrivalAirportId, LocalDate departureTime);
}
