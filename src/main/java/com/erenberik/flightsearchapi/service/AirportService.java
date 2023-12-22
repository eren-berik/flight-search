package com.erenberik.flightsearchapi.service;

import com.erenberik.flightsearchapi.dto.AirportCreateReqDTO;
import com.erenberik.flightsearchapi.dto.AirportResDTO;
import com.erenberik.flightsearchapi.dto.AirportUpdateReqDTO;
import com.erenberik.flightsearchapi.model.Airport;

import java.util.List;

public interface AirportService {
    AirportResDTO createAirport(AirportCreateReqDTO airportCreateReqDTO);
    List<AirportResDTO> getAllAirports();
    Airport getAirportById(Long id);
    AirportResDTO updateAirport(AirportUpdateReqDTO airportUpdateReqDTO, Long id);

    void deleteAirport(Long id);
}
