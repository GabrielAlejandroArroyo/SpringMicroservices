package com.microservice.catalog.persistence;

import com.microservice.catalog.entities.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICityRepository extends CrudRepository <City, Long> {
}
