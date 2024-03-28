package com.microservice.catalog.service;

import com.microservice.catalog.entities.Neighborhood;
import com.microservice.catalog.entities.State;
import com.microservice.catalog.persistence.INeighborhoodRepository;
import com.microservice.catalog.persistence.IStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StateServiceImpl implements IStateService{

    @Autowired
    private IStateRepository stateRepository;
    @Override
    public List<State> findAll() {
        return (List<State>) stateRepository.findAll();
    }

    @Override
    public State findById(Long id) {
        return stateRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(State state) {
        stateRepository.save(state);

    }
}
