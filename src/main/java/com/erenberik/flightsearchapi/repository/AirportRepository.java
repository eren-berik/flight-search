package com.erenberik.flightsearchapi.repository;

import com.erenberik.flightsearchapi.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport, Long> {
}
