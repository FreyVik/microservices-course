package com.freyvik.clients.service;

import com.freyvik.clients.model.Country;

import java.util.List;

public interface CountryService {

    List<Country> findAllCountries();

    List<Country> findByName(String name);
}
