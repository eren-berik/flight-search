package com.erenberik.flightsearchapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AirportResDTO {
    private Long id;
    private String name;
    private Integer plateCode;
}