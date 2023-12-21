package com.erenberik.flightsearchapi.dto;

import com.erenberik.flightsearchapi.model.Airport;
import lombok.Data;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Data
public class FlightDto {
    private int id;
    //todo: for departure and arrival airports type will be Airport
    private Airport departureAirport;
    private Airport arrivalAirport;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private float price;
}
