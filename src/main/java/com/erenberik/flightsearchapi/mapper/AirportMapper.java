package com.erenberik.flightsearchapi.mapper;

import com.erenberik.flightsearchapi.dto.AirportCreateReqDTO;
import com.erenberik.flightsearchapi.dto.AirportResDTO;
import com.erenberik.flightsearchapi.dto.AirportUpdateReqDTO;
import com.erenberik.flightsearchapi.model.Airport;
import com.erenberik.flightsearchapi.model.City;
import com.erenberik.flightsearchapi.service.CityService;
import com.erenberik.flightsearchapi.service.impl.CityServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AirportMapper {

    private final CityService cityService;

    public AirportResDTO mapToAirportResponseDTO(Airport airport) {
        return AirportResDTO.builder()
                .id(airport.getId())
                .name(airport.getName())
                .cityCode(airport.getCity().getCityCode())
                .build();
    }

    public Airport mapToAirport(AirportCreateReqDTO airportCreateReqDTO) {

        City city = cityService.getCityByCityCode(airportCreateReqDTO.getCityCode());

        return Airport.builder()
                .name(airportCreateReqDTO.getName())
                .city(city)
                .build();
    }

    public Airport mapToAirport(AirportUpdateReqDTO airportUpdateReqDTO) {

        City city = cityService.getCityByCityCode(airportUpdateReqDTO.getCityCode());

        return Airport.builder()
                .id(airportUpdateReqDTO.getId())
                .name(airportUpdateReqDTO.getName())
                .city(city)
                .build();
    }
}
