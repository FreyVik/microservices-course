package com.freyvik.clients.controller;

import com.freyvik.clients.model.Country;
import com.freyvik.clients.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {

    @Autowired
    CountryService countryService;

    @GetMapping(value = "/countries", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Country> countries() {
        return countryService.findAllCountries();
    }

    @GetMapping(value = "/countries/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Country> countries(@PathVariable("name") String name) {
        return countryService.findByName(name);
    }
}
