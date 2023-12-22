package com.erenberik.flightsearchapi.mapper;

import com.erenberik.flightsearchapi.dto.AirportCreateReqDTO;
import com.erenberik.flightsearchapi.dto.AirportResDTO;
import com.erenberik.flightsearchapi.dto.AirportUpdateReqDTO;
import com.erenberik.flightsearchapi.model.Airport;
import com.erenberik.flightsearchapi.model.City;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AirportMapper {
    /*public static AirportDto mapToDto(Airport airport) {
        AirportDto airportDto = new AirportDto();
        airportDto.setId(airport.getId());
        airportDto.setCity(airport.getCity());

        return airportDto;
    }*/

    public AirportResDTO mapToAirportResponseDTO(Airport airport) {
        return AirportResDTO.builder()
                .id(airport.getId())
                .name(airport.getName())
                .plateCode(airport.getCity().getCityCode())
                .build();
    }

    public Airport mapToAirport(AirportCreateReqDTO airportCreateReqDTO) {

        //todo: implement city service
        //City city = cityService.getByPlateCode(airportCreateReqDTO.getPlateCode());

        return Airport.builder()
                .name(airportCreateReqDTO.getName())
                //.city(city)
                .build();
    }
}
