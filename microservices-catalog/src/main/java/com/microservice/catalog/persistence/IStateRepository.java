package com.microservice.catalog.persistence;

import com.microservice.catalog.entities.State;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStateRepository  extends CrudRepository<State, Long> {
}
