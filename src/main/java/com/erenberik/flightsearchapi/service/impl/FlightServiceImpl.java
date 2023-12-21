package com.erenberik.flightsearchapi.service.impl;

import com.erenberik.flightsearchapi.exception.FlightNotFoundException;
import com.erenberik.flightsearchapi.repository.FlightRepository;
import com.erenberik.flightsearchapi.service.FlightService;
import com.erenberik.flightsearchapi.model.Flight;
import com.erenberik.flightsearchapi.dto.FlightDto;
import com.erenberik.flightsearchapi.mapper.FlightMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightServiceImpl implements FlightService {
    private final FlightRepository flightRepository;

    @Autowired
    public FlightServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public FlightDto createFlight(Flight flight) {
        Flight newFlight = flightRepository.save(flight);

        return FlightMapper.mapToDto(newFlight);
    }

    @Override
    public FlightDto getFlightById(int id) {
        Flight flight = flightRepository.findById(id).orElseThrow(() -> new FlightNotFoundException("Flight could not be found!"));

        return FlightMapper.mapToDto(flight);
    }

    @Override
    public List<FlightDto> getAllFlights() {
        List<Flight> flight = flightRepository.findAll();

        List<FlightDto> flightDtoList = flight.stream()
                .map(FlightMapper::mapToDto)
                .collect(Collectors.toList());

        return flightDtoList;
    }

    @Override
    public FlightDto updateFlight(Flight flight, int id) {
        Flight findFlight = flightRepository.findById(id).orElseThrow(() -> new FlightNotFoundException("Flight could not be found!"));

        findFlight.setDepartureAirport(flight.getDepartureAirport());
        findFlight.setArrivalAirport(flight.getArrivalAirport());
        findFlight.setDepartureTime(flight.getDepartureTime());
        findFlight.setArrivalTime(flight.getArrivalTime());
        findFlight.setPrice(flight.getPrice());

        Flight updatedFlight = flightRepository.save(findFlight);
        System.out.println(updatedFlight);
        return FlightMapper.mapToDto(updatedFlight);
    }

    @Override
    public void deleteFlightById(int id) {
        Flight flight = flightRepository.findById(id).orElseThrow(() -> new FlightNotFoundException("Flight could not be found"));
        flightRepository.delete(flight);
    }
}
