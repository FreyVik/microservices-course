package com.freyvik.clients.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.freyvik.clients.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryServiceImpl implements CountryService {

    private static final String COUNTRY_URL = "https://restcountries.com/v3.1/all";

    @Autowired
    RestTemplate restTemplate;

    @Override
    public List<Country> findAllCountries() {
        String result = restTemplate.getForObject(COUNTRY_URL, String.class);
        ObjectMapper mapper = new ObjectMapper();
        List<Country> countries = new ArrayList<>();

        ArrayNode array;

        String failCountry = "";

        try {
            array =  (ArrayNode) mapper.readTree(result);

            for (Object ob : array) {
                ObjectNode json = (ObjectNode) ob;

                failCountry = json.get("name").get("common").asText();

                String country = json.get("name").get("common").asText();
                String capital = "";
                if (json.get("capital") != null) {
                    capital = json.get("capital").get(0).asText();
                }
                int population = json.get("population").asInt();
                String flag = json.get("flag").asText();

                countries.add(new Country(country,
                        capital,
                        population,
                        flag
                ));
            }

        } catch (Exception e) {
            System.out.println("fail: " + failCountry);
            e.printStackTrace();
        }

        return countries;
    }

    @Override
    public List<Country> findByName(String name) {
        return findAllCountries().stream()
                .filter(country -> country.getName().contains(name))
                .collect(Collectors.toList());
    }
}
