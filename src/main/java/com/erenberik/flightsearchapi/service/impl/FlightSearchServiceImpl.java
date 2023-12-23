package com.erenberik.flightsearchapi.service.impl;

import com.erenberik.flightsearchapi.dto.FlightResDTO;
import com.erenberik.flightsearchapi.dto.FlightSearchResDTO;
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

    @Override
    public FlightSearchResDTO flightSearch(Long departureAirportId, Long arrivalAirportId, LocalDate departureTime, Optional<LocalDate> returnTime) {

        if (returnTime.isPresent()) {
            return searchRoundTripFlight(departureAirportId, arrivalAirportId, departureTime, returnTime.get());
        } else {
            return searchOneWayFlight(departureAirportId, arrivalAirportId, departureTime);
        }

    }

    private FlightSearchResDTO searchOneWayFlight(Long departureAirportId, Long arrivalAirportId, LocalDate departureTime) {

        //todo: Implement findByDepartureAirportIdAndArrivalAirportIdAndDepartureTime in the flight service
        List<FlightResDTO> outboundFlights = flightService.findByDepartureAirportIdAndArrivalAirportIdAndDepartureTime
                (departureAirportId, arrivalAirportId, departureTime);

        //todo: Implement flightSearchMapper
        return flightSearchMapper.mapToFlightSearchResDTO(outboundFlights);

    }

    private FlightSearchResDTO searchRoundTripFlight(Long departureAirportId, Long arrivalAirportId, LocalDate departureTime, LocalDate returnTime) {

        //todo: Implement findByDepartureAirportIdAndArrivalAirportIdAndDepartureTime in the flight service
        List<FlightResDTO> outboundFlights = flightService.findByDepartureIdAndArrivalIdAndDepartureTime(departureAirportId, arrivalAirportId, departureTime);
        List<FlightResDTO> inboundFlights = flightService.findByDepartureIdAndArrivalIdAndDepartureTime(arrivalAirportId, departureAirportId, returnTime);

        //todo: Implement flightSearchMapper
        return flightSearchMapper.mapToFlightSearchResponseDTO(outboundFlights, inboundFlights);
    }
}
