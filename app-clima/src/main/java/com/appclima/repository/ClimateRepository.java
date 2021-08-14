package com.appclima.repository;

import com.appclima.entity.CityEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClimateRepository extends CrudRepository<CityEntity, Long> {
}