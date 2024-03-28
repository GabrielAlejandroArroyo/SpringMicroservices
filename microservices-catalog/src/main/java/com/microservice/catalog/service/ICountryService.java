package com.microservice.catalog.service;

import com.microservice.catalog.entities.Country;

import java.util.List;

public interface ICountryService {
    List<Country> findAll();

    Country findById(Long id);

    void save(Country country);

    void delete(Country country);

    void deleteById(Long id);


}
