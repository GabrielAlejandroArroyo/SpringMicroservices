package com.microservice.catalog.service;

import com.microservice.catalog.entities.City;

import java.util.List;

public interface ICityService {
    List<City> findAll();

    City findById(Long id);

    void save(City city);
}
