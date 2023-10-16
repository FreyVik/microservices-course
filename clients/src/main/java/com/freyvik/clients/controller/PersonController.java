package com.freyvik.clients.controller;

import com.freyvik.clients.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
public class PersonController {

    @Autowired
    RestTemplate restTemplate;

    private static final String URL = "http://localhost:8080";

    @GetMapping(value = "/person/{name}/{email}/{age}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> releasePerson(
            @PathVariable("name") String name,
            @PathVariable("email") String email,
            @PathVariable("age") int age
    ) {
        Person newPerson = new Person(name, email, age);
        restTemplate.postForLocation(URL + "/contact", newPerson);

        Person[] persons = restTemplate.getForObject(URL + "/contacts", Person[].class);

        assert persons != null;
        return Arrays.asList(persons);
    }
}
