package com.erenberik.flightsearchapi.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FlightSearchResDTO {
    List<FlightResDTO> flights;
    //List<FlightResDTO> inboundFlights;
}
