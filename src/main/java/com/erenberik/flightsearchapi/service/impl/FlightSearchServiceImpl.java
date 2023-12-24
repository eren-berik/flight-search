package com.erenberik.flightsearchapi.service.impl;

import com.erenberik.flightsearchapi.dto.FlightResDTO;
import com.erenberik.flightsearchapi.dto.FlightSearchResDTO;
import com.erenberik.flightsearchapi.mapper.FlightSearchMapper;
import com.erenberik.flightsearchapi.service.FlightSearchService;
import com.erenberik.flightsearchapi.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FlightSearchServiceImpl implements FlightSearchService {

    private final FlightService flightService;
    private final FlightSearchMapper flightSearchMapper;

    @Override
    public FlightSearchResDTO flightSearch(Long departureAirportId, Long arrivalAirportId, LocalDate departureTime, Optional<LocalDate> returnTime) {

        if (returnTime != null && returnTime.isPresent()) {
            return searchRoundTripFlight(departureAirportId, arrivalAirportId, departureTime, returnTime.get());
        } else {
            return searchOneWayFlight(departureAirportId, arrivalAirportId, departureTime);
        }

    }

    private FlightSearchResDTO searchOneWayFlight(Long departureAirportId, Long arrivalAirportId, LocalDate departureTime) {

        List<FlightResDTO> outboundFlights = flightService.findByDepartureIdAndArrivalIdAndDepartureTime(departureAirportId, arrivalAirportId, departureTime);

        return flightSearchMapper.mapToFlightSearchResDTO(outboundFlights);

    }

    private FlightSearchResDTO searchRoundTripFlight(Long departureAirportId, Long arrivalAirportId, LocalDate departureTime, LocalDate returnTime) {

        List<FlightResDTO> outboundFlights = flightService.findByDepartureIdAndArrivalIdAndDepartureTime(departureAirportId, arrivalAirportId, departureTime);
        List<FlightResDTO> inboundFlights = flightService.findByDepartureIdAndArrivalIdAndDepartureTime(arrivalAirportId, departureAirportId, returnTime);

        return flightSearchMapper.mapToFlightSearchResDTO(outboundFlights, inboundFlights);
    }
}
