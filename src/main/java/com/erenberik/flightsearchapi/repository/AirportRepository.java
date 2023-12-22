package com.erenberik.flightsearchapi.repository;

import com.erenberik.flightsearchapi.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {
    boolean existsByNameAndCity_CityCode(String name, Integer cityCode);
}
