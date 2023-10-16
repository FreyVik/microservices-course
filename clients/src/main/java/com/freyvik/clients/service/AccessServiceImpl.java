package com.freyvik.clients.service;

import com.freyvik.clients.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class AccessServiceImpl implements AccessService {

    @Autowired
    RestTemplate restTemplate;

    private static final String URL = "http://localhost:8080";

    @Async
    @Override
    public CompletableFuture<List<Person>> asyncReleasePerson(Person newPerson) {
        restTemplate.postForLocation(URL + "/contact", newPerson);
        Person[] persons = restTemplate.getForObject(URL + "/contacts", Person[].class);

        assert persons != null;
        return CompletableFuture.completedFuture(Arrays.asList(persons));
    }
}
