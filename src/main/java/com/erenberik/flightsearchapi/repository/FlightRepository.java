package com.erenberik.flightsearchapi.repository;

import com.erenberik.flightsearchapi.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;


public interface FlightRepository extends JpaRepository<Flight,Long> {
    List<Flight> findAllByArrivalAirport_IdAndDepartureAirport_IdAndDepartureTimeBetweenOrderByDepartureTime(Long arrivalAirportId, Long departureAirportId, LocalDateTime startDate, LocalDateTime endDate);
}
