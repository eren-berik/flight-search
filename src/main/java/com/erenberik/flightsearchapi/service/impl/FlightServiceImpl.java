package com.erenberik.flightsearchapi.service.impl;

import com.erenberik.flightsearchapi.dto.FlightCreateReqDTO;
import com.erenberik.flightsearchapi.dto.FlightResDTO;
import com.erenberik.flightsearchapi.dto.FlightUpdateReqDTO;
import com.erenberik.flightsearchapi.exception.AlreadyExistsException;
import com.erenberik.flightsearchapi.exception.NotFoundException;
import com.erenberik.flightsearchapi.exception.errors.FlightErrors;
import com.erenberik.flightsearchapi.repository.FlightRepository;
import com.erenberik.flightsearchapi.service.FlightService;
import com.erenberik.flightsearchapi.model.Flight;
import com.erenberik.flightsearchapi.mapper.FlightMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;
    private final FlightMapper flightMapper;

    @Override
    public FlightResDTO createFlight(FlightCreateReqDTO flightCreateReqDTO) {
        //Check might add here but is it possible that multiple flights share exactly same values rather than id?
        //EXAMPLE CASE -> Airport with multiple runways may allow multiple flights at the same time so theoretically above
        //statement is possible.
        Flight flight = flightMapper.mapToFlight(flightCreateReqDTO);
        flight = flightRepository.save(flight);

        return flightMapper.mapToFlightResDTO(flight);
    }

    @Override
    public FlightResDTO getFlightById(Long id) {
        Flight flight = flightRepository.findById(id).orElseThrow(() -> new NotFoundException(FlightErrors.FLIGHT_NOT_FOUND));

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
    public FlightResDTO updateFlight(FlightUpdateReqDTO flightUpdateReqDTO, @PathVariable Long id) {
        if (!isExistsById(id)) {
            throw new NotFoundException(FlightErrors.FLIGHT_NOT_FOUND);
        }

        flightUpdateReqDTO.setId(id);
        Flight flight = flightMapper.mapToFlight(flightUpdateReqDTO);
        flight = flightRepository.save(flight);

        return flightMapper.mapToFlightResDTO(flight);
    }

    @Override
    public void deleteFlightById(Long id) {
        if (!isExistsById(id)) {
            throw new AlreadyExistsException(FlightErrors.FLIGHT_NOT_FOUND);
        }

        flightRepository.deleteById(id);
    }

    @Override
    public List<FlightResDTO> findByDepartureIdAndArrivalIdAndDepartureTime(Long departureAirportId, Long arrivalAirportId, LocalDate departureTime) {

        LocalDateTime startDate = LocalDateTime.of(departureTime, LocalTime.of(0, 0, 0, 0));
        LocalDateTime endDate = LocalDateTime.of(departureTime.plusDays(1), LocalTime.of(0, 0, 0, 0));

        List<Flight> flights = flightRepository.findAllByArrivalAirport_IdAndDepartureAirport_IdAndDepartureTimeBetweenOrderByDepartureTime(arrivalAirportId, departureAirportId, startDate, endDate);

        return flights.stream().map(flightMapper::mapToFlightResDTO).toList();
    }

    //Helper methods
    private boolean isExistsById(Long id) {
        return flightRepository.existsById(id);
    }
}