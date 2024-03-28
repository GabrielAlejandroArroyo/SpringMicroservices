package com.microservice.catalog.service;

import com.microservice.catalog.entities.City;
import com.microservice.catalog.entities.Neighborhood;

import java.util.List;

public interface INeighborhoodService {
    List<Neighborhood> findAll();

    Neighborhood findById(Long id);

    void save(Neighborhood neighborhood);
}
