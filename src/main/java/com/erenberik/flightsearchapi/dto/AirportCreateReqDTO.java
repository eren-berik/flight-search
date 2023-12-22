package com.erenberik.flightsearchapi.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AirportCreateReqDTO {
    private String name;
    private Integer cityCode;
}
