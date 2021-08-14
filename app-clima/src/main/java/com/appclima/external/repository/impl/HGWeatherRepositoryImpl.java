package com.appclima.external.repository.impl;

import com.appclima.dto.WeatherResponseDTO;
import com.appclima.external.repository.HGWeatherRepository;
import com.appclima.external.response.WeatherResponse;
import com.google.common.net.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class HGWeatherRepositoryImpl implements HGWeatherRepository {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${hgWeather.api.token}")
    private String token;

    @Value("${hgWeather.api.host}")
    private String host;

    @Value("${hgWeather.api.path.getWeatherByName}")
    private String getWeatherPath;

    public WeatherResponse showCities(String city){

        String endpoint = host + String.format(getWeatherPath, token, city);

        try {
            WeatherResponse response = restTemplate
                    .getForObject(endpoint, WeatherResponse.class);
            return response;
        } catch (Exception e) {
            return null;
        }
    }

}
