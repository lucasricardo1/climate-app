package com.appclima.external.repository;

import com.appclima.external.response.WeatherResponse;
import org.springframework.stereotype.Repository;

@Repository
public interface HGWeatherRepository {

    WeatherResponse showCities(String city);
}
