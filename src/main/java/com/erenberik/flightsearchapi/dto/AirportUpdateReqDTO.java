package com.erenberik.flightsearchapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class AirportUpdateReqDTO {
    private Long id;
    private String name;
    private Integer plateCode;
}
