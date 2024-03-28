package com.microservice.catalog.service;

import com.microservice.catalog.entities.State;

import java.util.List;

public interface IStateService {
    List<State> findAll();

    State findById(Long id);

    void save(State state);
}
