package com.microservice.catalog.service;

import com.microservice.catalog.entities.City;
import com.microservice.catalog.persistence.ICityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements ICityService{

    @Autowired
    private ICityRepository cityRepository;
    @Override
    public List<City> findAll() {
        {
            return (List<City>) cityRepository.findAll();
        }
    }

    @Override
    public City findById(Long id) {
        return cityRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(City city) {
        cityRepository.save(city);

    }
}
