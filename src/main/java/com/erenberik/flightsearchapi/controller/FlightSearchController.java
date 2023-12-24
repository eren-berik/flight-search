package com.erenberik.flightsearchapi.controller;

import com.erenberik.flightsearchapi.dto.FlightSearchReq;
import com.erenberik.flightsearchapi.dto.FlightSearchResDTO;
import com.erenberik.flightsearchapi.dto.RestResponse;
import com.erenberik.flightsearchapi.service.FlightSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("search")
@RequiredArgsConstructor
public class FlightSearchController {

    private final FlightSearchService flightSearchService;

    @GetMapping
    public ResponseEntity<RestResponse<FlightSearchResDTO>> search(@RequestBody FlightSearchReq flightSearchReq) {

        FlightSearchResDTO flightSearchResDTO = flightSearchService.flightSearch(
                flightSearchReq.getDepartureAirportId(),
                flightSearchReq.getArrivalAirportId(),
                flightSearchReq.getDepartureTime(),
                flightSearchReq.getReturnTime());

        return ResponseEntity.ok(RestResponse.of(flightSearchResDTO));
    }
}
