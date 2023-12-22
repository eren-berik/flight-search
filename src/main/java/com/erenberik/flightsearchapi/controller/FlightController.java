package com.erenberik.flightsearchapi.controller;

import com.erenberik.flightsearchapi.dto.FlightCreateReqDTO;
import com.erenberik.flightsearchapi.dto.FlightResDTO;
import com.erenberik.flightsearchapi.dto.FlightUpdateReqDTO;
import com.erenberik.flightsearchapi.dto.RestResponse;
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
    public ResponseEntity<RestResponse<List<FlightResDTO>>> getAllFlights() {
        List <FlightResDTO> flightResDTOList = flightService.getAllFlights();

        return ResponseEntity.ok(RestResponse.of(flightResDTOList));
    }

    @PostMapping("flight")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<RestResponse<FlightResDTO>> createFlight(@RequestBody FlightCreateReqDTO flightCreateReqDTO){
        FlightResDTO flightResDTO = flightService.createFlight(flightCreateReqDTO);

        return ResponseEntity.ok(RestResponse.of(flightResDTO));
    }

    @GetMapping("flight/{id}")
    public ResponseEntity<RestResponse<FlightResDTO>> getFlightById(@PathVariable Long id) {
        FlightResDTO flightResDTO = flightService.getFlightById(id);

        return ResponseEntity.ok(RestResponse.of(flightResDTO));
    }

    @PutMapping("flight/{id}")
    public ResponseEntity<RestResponse<FlightResDTO>> updateFlight(@RequestBody FlightUpdateReqDTO flightUpdateReqDTO, @PathVariable Long id){
        FlightResDTO flightResDTO = flightService.updateFlight(flightUpdateReqDTO, id);

        return ResponseEntity.ok(RestResponse.of(flightResDTO));
    }

    @DeleteMapping("flight/{id}")
    public ResponseEntity<RestResponse<Void>> deleteFlight(@PathVariable Long id) {
        flightService.deleteFlightById(id);

        return ResponseEntity.ok(RestResponse.empty());
    }
}
