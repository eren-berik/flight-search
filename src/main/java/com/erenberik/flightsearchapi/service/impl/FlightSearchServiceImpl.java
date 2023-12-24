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
            return searchFlights(departureAirportId, arrivalAirportId, departureTime, returnTime);
        } else {
            return searchFlights(departureAirportId, arrivalAirportId, departureTime, Optional.empty());
        }

    }

    private FlightSearchResDTO searchFlights(Long departureAirportId, Long arrivalAirportId, LocalDate departureTime, Optional<LocalDate> returnTime) {

        List<FlightResDTO> flights = flightService.findAllByArrivalAirport_IdAndDepartureAirport_IdAndDepartureTimeBetweenOrderByDepartureTime
                (departureAirportId, arrivalAirportId, departureTime, Optional.of(returnTime));

        return flightSearchMapper.mapToFlightSearchResDTO(flights);

    }

    /*private FlightSearchResDTO searchRoundTripFlight(Long departureAirportId, Long arrivalAirportId, LocalDate departureTime, LocalDate returnTime) {

        //todo: Implement findByDepartureAirportIdAndArrivalAirportIdAndDepartureTime in the flight service
        List<FlightResDTO> outboundFlights = flightService.findByDepartureIdAndArrivalIdAndDepartureTime(departureAirportId, arrivalAirportId, departureTime);
        List<FlightResDTO> inboundFlights = flightService.findByDepartureIdAndArrivalIdAndDepartureTime(arrivalAirportId, departureAirportId, returnTime);

        //todo: Implement flightSearchMapper
        return flightSearchMapper.mapToFlightSearchResponseDTO(outboundFlights, inboundFlights);
    }*/
}
