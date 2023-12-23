package com.erenberik.flightsearchapi.service;

import com.erenberik.flightsearchapi.dto.FlightSearchResDTO;

import java.time.LocalDate;
import java.util.Optional;

public interface FlightSearchService {
    FlightSearchResDTO flightSearch(Long departureAirportId, Long arrivalAirportId, LocalDate departureTime, Optional<LocalDate> returnTime);
}
