package com.appclima.service;

import com.appclima.dto.CityDTO;
import com.appclima.entity.CityEntity;
import com.appclima.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;
    @Transactional
    public CityEntity addCity(CityDTO cityDTO) {
        return cityRepository.save(CityEntity.builder().woeid(cityDTO.getWoeid()).cityName(cityDTO.getCityName()).build());
    }

    @Transactional
    public void deleteCity(Long id) {
        cityRepository.deleteById(id);
    }
}
