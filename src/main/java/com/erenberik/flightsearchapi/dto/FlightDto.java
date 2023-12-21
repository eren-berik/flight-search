package com.erenberik.flightsearchapi.dto;

import lombok.Data;

@Data
public class FlightDto {
    private int id;
    //todo: for departure and arrival airports type will be Airport
    private String departureAirport;
    private String arrivalAirport;
    private String departureTime;
    private String arrivalTime;
    private float price;
}
