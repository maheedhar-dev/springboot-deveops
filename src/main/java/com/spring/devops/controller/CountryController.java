package com.spring.devops.controller;

import com.spring.devops.entity.Country;
import com.spring.devops.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }
    @GetMapping("/countries")
    public ResponseEntity<List<Country>> getCountries() {
        List<Country> countries = countryService.getCountries();
        return ResponseEntity.ok(countries);
    }

    @PostMapping("/country")
    public ResponseEntity<Country> addCountry(@RequestBody Country country) {
        Country savedCountry = countryService.addCountry(country);
        return ResponseEntity.ok(savedCountry);
    }

}
