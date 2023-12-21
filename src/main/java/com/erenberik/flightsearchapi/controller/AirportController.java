package com.erenberik.flightsearchapi.controller;

import com.erenberik.flightsearchapi.dto.AirportDto;
import com.erenberik.flightsearchapi.model.Airport;
import com.erenberik.flightsearchapi.service.AirportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("airport/{id}")
    public ResponseEntity<AirportDto> getAirportById(@PathVariable int id) {
        AirportDto response = airportService.getAirportById(id);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("airport")
    public ResponseEntity<List<AirportDto>> getAllAirports() {
        List<AirportDto> response = airportService.getAllAirports();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("airport/{id}")
    public ResponseEntity<AirportDto> updateAirport(@RequestBody AirportDto airportDto, @PathVariable int id) {
        AirportDto response = airportService.updateAirport(airportDto, id);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("airport/{id}")
    public ResponseEntity<String> deleteAirport(@PathVariable int id) {
        airportService.deleteAirport(id);

        return new ResponseEntity<>("Airport deleted", HttpStatus.OK);
    }
}
