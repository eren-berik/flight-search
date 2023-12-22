package com.erenberik.flightsearchapi.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AirportUpdateReqDTO {
    private Long id;
    private String name;
    private Integer cityCode;
}
