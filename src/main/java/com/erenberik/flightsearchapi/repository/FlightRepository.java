package com.erenberik.flightsearchapi.repository;

import com.erenberik.flightsearchapi.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FlightRepository extends JpaRepository<Flight,Long> {

}
