package com.cognizant.orm_learn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.repository.CountryRepository;

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }
//    public List<Country> getAllCountries() {
//        return countryRepository.findAll();
//    }
    public Optional<Country> getCountryByCode(String code) {
        return countryRepository.findById(code);
    }
    public Country addCountry(Country country) {
        return countryRepository.save(country);
    }
    public Country updateCountry(Country country) {
        return countryRepository.save(country);
    }
    public void deleteCountry(String code) {
        countryRepository.deleteById(code);
    }
    public List<Country> findCountriesByPartialName(String partialName) {
        return countryRepository.findByNameContainingIgnoreCase(partialName);
    }
}

