package com.erenberik.flightsearchapi.repository;

import com.erenberik.flightsearchapi.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Integer> {
}
