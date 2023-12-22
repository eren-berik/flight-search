package com.erenberik.flightsearchapi.controller;

import com.erenberik.flightsearchapi.dto.FlightCreateReqDTO;
import com.erenberik.flightsearchapi.dto.FlightResDTO;
import com.erenberik.flightsearchapi.dto.FlightUpdateReqDTO;
import com.erenberik.flightsearchapi.service.FlightService;
import com.erenberik.flightsearchapi.model.Flight;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class FlightController {
    private final FlightService flightService;

    @GetMapping("flight")
    public ResponseEntity<List<FlightResDTO>> getAllFlights() {
        List <FlightResDTO> flightResDTOList = flightService.getAllFlights();

        return new ResponseEntity<>(flightResDTOList, HttpStatus.OK);
    }

    @PostMapping("flight")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<FlightResDTO> createFlight(@RequestBody FlightCreateReqDTO flightCreateReqDTO){

        return new ResponseEntity<>(flightService.createFlight(flightCreateReqDTO), HttpStatus.CREATED);
    }

    @GetMapping("flight/{id}")
    public ResponseEntity<FlightResDTO> getFlightById(@PathVariable Long id) {
        FlightResDTO flightResDTO = flightService.getFlightById(id);

        return new ResponseEntity<>(flightResDTO, HttpStatus.OK);
    }

    @PutMapping("flight/{id}")
    public ResponseEntity<FlightResDTO> updateFlight(@RequestBody FlightUpdateReqDTO flightUpdateReqDTO, @PathVariable Long id){
        FlightResDTO flightResDTO = flightService.updateFlight(flightUpdateReqDTO, id);

        return new ResponseEntity<>(flightResDTO,HttpStatus.OK);
    }

    @DeleteMapping("flight/{id}")
    public ResponseEntity<String> deleteFlight(@PathVariable Long id) {
        flightService.deleteFlightById(id);

        return new ResponseEntity<>("Flight deleted!", HttpStatus.OK);
    }
}
