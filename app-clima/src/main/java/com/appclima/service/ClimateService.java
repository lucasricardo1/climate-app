package com.appclima.service;

import com.appclima.entity.CityEntity;
import com.appclima.external.repository.HGWeatherRepository;
import com.appclima.external.response.WeatherResponse;
import com.appclima.repository.ClimateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClimateService {

    @Autowired
    private HGWeatherRepository hgRepository;

    @Autowired
    private ClimateRepository climateRepository;

    public List<WeatherResponse> showCities() {
        Iterable<CityEntity> cities = climateRepository.findAll();

        List<WeatherResponse> responses = new ArrayList<>();
        cities.forEach(city -> {
            WeatherResponse response = hgRepository.showCities(city.getCityName());
            if (response != null) {
                responses.add(response);
            }
        });

        return responses;
    }

}
