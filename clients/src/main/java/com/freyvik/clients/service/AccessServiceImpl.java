package com.freyvik.clients.service;

import com.freyvik.clients.model.Person;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
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
    String user = "admin";
    String pwd = "admin";
    String token;
    HttpHeaders headers = new HttpHeaders();

    @PostConstruct
    public void authenticate() {
        token = restTemplate.postForObject(URL + "/login?user=" +  user + "&pwd=" + pwd, null, String.class);
        headers.add("Authorization", "Bearer " + token);
    }

    @Async
    @Override
    public CompletableFuture<List<Person>> asyncReleasePerson(Person newPerson) {
        restTemplate.exchange(URL + "/contact", HttpMethod.POST, new HttpEntity<Person>(newPerson, headers), String.class);
        Person[] persons = restTemplate.exchange(URL + "/contacts", HttpMethod.GET, new HttpEntity<>(headers), Person[].class).getBody();

        assert persons != null;
        return CompletableFuture.completedFuture(Arrays.asList(persons));
    }
}
