package com.microservice.catalog.persistence;

import com.microservice.catalog.entities.Neighborhood;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INeighborhoodRepository extends CrudRepository <Neighborhood, Long> {
}
