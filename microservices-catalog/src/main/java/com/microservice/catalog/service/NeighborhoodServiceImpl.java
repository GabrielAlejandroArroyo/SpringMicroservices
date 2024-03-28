package com.microservice.catalog.service;

import com.microservice.catalog.entities.Country;
import com.microservice.catalog.entities.Neighborhood;
import com.microservice.catalog.persistence.ICountryRepository;
import com.microservice.catalog.persistence.INeighborhoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NeighborhoodServiceImpl implements INeighborhoodService{

    @Autowired
    private INeighborhoodRepository neighborhoodRepository;
    @Override
    public List<Neighborhood> findAll() {
        return (List<Neighborhood>) neighborhoodRepository.findAll();
    }

    @Override
    public Neighborhood findById(Long id) {
        return neighborhoodRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Neighborhood neighborhood) {
        neighborhoodRepository.save(neighborhood);
    }
}
