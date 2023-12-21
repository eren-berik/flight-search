package com.erenberik.flightsearchapi.controller;

import com.erenberik.flightsearchapi.service.FlightService;
import com.erenberik.flightsearchapi.model.Flight;
import com.erenberik.flightsearchapi.service.FlightService;
import com.erenberik.flightsearchapi.dto.FlightDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class FlightController {
    private final FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @PostMapping("flight")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<FlightDto> createFlight(
            @RequestBody Flight flight){

        return new ResponseEntity<>(flightService.createFlight(flight), HttpStatus.CREATED);
    }

    @GetMapping("flight/{id}")
    public ResponseEntity<FlightDto> flightDetails(@PathVariable int id) {
        FlightDto response = flightService.getFlightById(id);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("flight/")
    public ResponseEntity<List<FlightDto>> getAllFlights() {
        List<FlightDto> response = flightService.getAllFlights();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("flight/{id}")
    public ResponseEntity<FlightDto> updateFlight(
            @RequestBody Flight flight,
            @PathVariable int id
    ){
        FlightDto response = flightService.updateFlight(flight, id);

        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @DeleteMapping("flight/{id}")
    public ResponseEntity<String> deleteFlight(@PathVariable int id) {
        flightService.deleteFlightById(id);

        return new ResponseEntity<>("Flight deleted", HttpStatus.OK);
    }
}
