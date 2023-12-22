package com.erenberik.flightsearchapi.mapper;

import com.erenberik.flightsearchapi.dto.FlightCreateReqDTO;
import com.erenberik.flightsearchapi.dto.FlightResDTO;
import com.erenberik.flightsearchapi.dto.FlightUpdateReqDTO;
import com.erenberik.flightsearchapi.model.Airport;
import com.erenberik.flightsearchapi.model.Flight;
import com.erenberik.flightsearchapi.service.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FlightMapper {

    private final AirportService airportService;

    public FlightResDTO mapToFlightResDTO(Flight flight) {

        return FlightResDTO.builder()
                .id(flight.getId())
                .departureAirportName(flight.getDepartureAirport().getAirportName())
                .arrivalAirportName(flight.getArrivalAirport().getAirportName())
                .departureTime(flight.getDepartureTime())
                .arrivalTime(flight.getArrivalTime())
                .price(flight.getPrice())
                .build();
    }

    public Flight mapToFlight(FlightCreateReqDTO flightCreateReqDTO) {

        Airport departureAirport = airportService.getAirportById(flightCreateReqDTO.getDepartureAirportId());
        Airport arrivalAirport = airportService.getAirportById(flightCreateReqDTO.getArrivalAirportId());

        return Flight.builder()
                .departureAirport(departureAirport)
                .arrivalAirport(arrivalAirport)
                .price(flightCreateReqDTO.getPrice())
                .departureTime(flightCreateReqDTO.getDepartureTime())
                .arrivalTime(flightCreateReqDTO.getArrivalTime())
                .build();
    }

    public Flight mapToFlight(FlightUpdateReqDTO flightUpdateReqDTO) {

        Airport departureAirport = airportService.getAirportById(flightUpdateReqDTO.getDepartureAirportId());
        Airport arrivalAirport = airportService.getAirportById(flightUpdateReqDTO.getArrivalAirportId());

        return Flight.builder()
                .id(flightUpdateReqDTO.getId())
                .departureAirport(departureAirport)
                .arrivalAirport(arrivalAirport)
                .departureTime(flightUpdateReqDTO.getDepartureTime())
                .arrivalTime(flightUpdateReqDTO.getArrivalTime())
                .price(flightUpdateReqDTO.getPrice())
                .build();
    }

}
