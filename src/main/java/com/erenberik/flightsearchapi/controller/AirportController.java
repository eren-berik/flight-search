package com.erenberik.flightsearchapi.controller;

import com.erenberik.flightsearchapi.dto.AirportDto;
import com.erenberik.flightsearchapi.model.Airport;
import com.erenberik.flightsearchapi.service.AirportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class AirportController {
    private final AirportService airportService;

    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @PostMapping("airport")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AirportDto> createAirport(@RequestBody Airport airport) {
        AirportDto response = airportService.createAirport(airport);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
