package com.erenberik.flightsearchapi.service.impl;

import com.erenberik.flightsearchapi.model.City;
import com.erenberik.flightsearchapi.repository.CityRepository;
import com.erenberik.flightsearchapi.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService{

    private final CityRepository cityRepository;

    @Override
    public City getCityByCityCode(Integer cityCode) {
        return cityRepository.findById(cityCode).orElseThrow(() -> new RuntimeException("City could not found!"));
    }
}
