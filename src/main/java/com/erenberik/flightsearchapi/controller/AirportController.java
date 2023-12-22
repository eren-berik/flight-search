package com.erenberik.flightsearchapi.controller;

import com.erenberik.flightsearchapi.dto.AirportCreateReqDTO;
import com.erenberik.flightsearchapi.dto.AirportResDTO;
import com.erenberik.flightsearchapi.dto.AirportUpdateReqDTO;
import com.erenberik.flightsearchapi.model.Airport;
import com.erenberik.flightsearchapi.service.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class AirportController {

    private final AirportService airportService;

    @GetMapping("airport")
    public ResponseEntity<List<AirportResDTO>> getAllAirports() {
        List<AirportResDTO> airportResDTOList = airportService.getAllAirports();

        return new ResponseEntity<>(airportResDTOList, HttpStatus.OK);
    }

    @PostMapping("airport")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AirportResDTO> createAirport(@RequestBody AirportCreateReqDTO airportCreateReqDTO) {
        AirportResDTO airportResDTO = airportService.createAirport(airportCreateReqDTO);

        return new ResponseEntity<>(airportResDTO, HttpStatus.CREATED);
    }

    @PutMapping("airport/{id}")
    public ResponseEntity<AirportResDTO> updateAirport(@RequestBody AirportUpdateReqDTO airportUpdateReqDTO, @PathVariable long id) {
        AirportResDTO airportResDTO = airportService.updateAirport(airportUpdateReqDTO, id);

        return new ResponseEntity<>(airportResDTO, HttpStatus.OK);
    }

    @DeleteMapping("airport/{id}")
    public ResponseEntity<String> deleteAirport(@PathVariable Long id) {
        airportService.deleteAirport(id);

        return new ResponseEntity<>("Airport deleted successfully.", HttpStatus.OK);
    }
}