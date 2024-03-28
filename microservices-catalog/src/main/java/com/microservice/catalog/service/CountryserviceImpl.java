package com.microservice.catalog.service;

import com.microservice.catalog.entities.Country;
import com.microservice.catalog.persistence.ICountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CountryserviceImpl implements ICountryService{

    @Autowired
    private ICountryRepository  countryRepository;
    @Override
    public List<Country> findAll() {
        List<Country> countries = (List<Country>)countryRepository.findAll();
        return  countries;
    }

    @Override
    public Country findById(Long id) {
        return countryRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Country country) {
        countryRepository.save(country);
    }

    @Override
    public void delete(Country country) {
        countryRepository.delete(country);

    }

    @Override
    public void deleteById(Long id) {
        countryRepository.deleteById(id);
    }


}
