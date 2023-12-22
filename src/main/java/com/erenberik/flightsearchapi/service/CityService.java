package com.erenberik.flightsearchapi.service;

import com.erenberik.flightsearchapi.model.City;

public interface CityService {

    City getCityByCityCode(Integer cityCode);
}
