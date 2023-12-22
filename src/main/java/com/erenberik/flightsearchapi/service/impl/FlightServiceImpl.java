package com.erenberik.flightsearchapi.service.impl;

import com.erenberik.flightsearchapi.dto.FlightCreateReqDTO;
import com.erenberik.flightsearchapi.dto.FlightResDTO;
import com.erenberik.flightsearchapi.dto.FlightUpdateReqDTO;
import com.erenberik.flightsearchapi.exception.FlightNotFoundException;
import com.erenberik.flightsearchapi.repository.AirportRepository;
import com.erenberik.flightsearchapi.repository.FlightRepository;
import com.erenberik.flightsearchapi.service.FlightService;
import com.erenberik.flightsearchapi.model.Flight;
import com.erenberik.flightsearchapi.mapper.FlightMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;
    private final FlightMapper flightMapper;

    @Override
    public FlightResDTO createFlight(FlightCreateReqDTO flightCreateReqDTO) {
        Flight flight = flightMapper.mapToFlight(flightCreateReqDTO);
        flight = flightRepository.save(flight);

        return flightMapper.mapToFlightResDTO(flight);
    }

    @Override
    public FlightResDTO getFlightById(Long id) {
        Flight flight = flightRepository.findById(id).orElseThrow(() -> new FlightNotFoundException("Flight could not be found!"));

        return flightMapper.mapToFlightResDTO(flight);
    }

    @Override
    public List<FlightResDTO> getAllFlights() {
        List<Flight> flight = flightRepository.findAll();
        flight.sort(Comparator.comparingLong(Flight::getId));

        return flight.stream()
                .map(flightMapper::mapToFlightResDTO)
                .collect(Collectors.toList());
    }

    @Override
    public FlightResDTO updateFlight(FlightUpdateReqDTO flightUpdateReqDTO, Long id) {
        Flight flight = flightRepository.findById(id).orElseThrow(() -> new FlightNotFoundException("Flight could not be found!"));
        Flight updateFlight = flightMapper.mapToFlight(flightUpdateReqDTO);

        flight.setDepartureAirport(updateFlight.getDepartureAirport());
        flight.setArrivalAirport(updateFlight.getArrivalAirport());
        flight.setDepartureTime(updateFlight.getDepartureTime());
        flight.setArrivalTime(updateFlight.getArrivalTime());
        flight.setPrice(updateFlight.getPrice());

        Flight saveUpdateFlight = flightRepository.save(flight);
        return flightMapper.mapToFlightResDTO(saveUpdateFlight);
    }

    @Override
    public void deleteFlightById(Long id) {
        //todo: Check if flight with that id exists or not
        flightRepository.deleteById(id);
    }
}
