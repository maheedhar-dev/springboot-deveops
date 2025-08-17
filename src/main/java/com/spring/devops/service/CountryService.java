package com.spring.devops.service;

import com.spring.devops.entity.Country;
import com.spring.devops.exception.BusinessException;
import com.spring.devops.exception.CountryAlreadyExistsException;
import com.spring.devops.repositories.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> getCountries() {
        List<Country> countries = countryRepository.findAll();
        if(countries.isEmpty()) {
            throw new BusinessException("No countries found");
        }
        return countries;
    }

    public Country addCountry(Country country) {
        if(country == null || country.getName() == null || country.getName().isEmpty()|| country.getCode() == null || country.getCode().isEmpty()) {
              throw new BusinessException("Country name or code cannot be null or empty");
         }
        // Check if a country with the same name already exists
        List<Country> countries = countryRepository.findAll();
        if(countries.stream().map(Country::getName).anyMatch(name -> name.equalsIgnoreCase(country.getName()))){
            throw new CountryAlreadyExistsException("Country with name " + country.getName() + " already exists");
        }
       countryRepository.save(country);
       return country;
    }
}
