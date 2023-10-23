package com.freyvik.clients.service;

import com.freyvik.clients.model.Person;
import com.freyvik.clients.model.ResultAuth;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class AccessServiceImpl implements AccessService {

    @Autowired
    RestTemplate restTemplate;

    private static final String SERVICE_URL = "http://localhost:8500";
    private static final String KEYCLOAK_URL = "http://localhost:8080/realms/ContactsRealm/protocol/openid-connect/token";
    final String USERNAME = "admin";
    final String PASSWORD = "admin";
    final String CLIENT_ID = "login";
    final String GRANT_TYPE = "password";

    HttpHeaders headersService = new HttpHeaders();

    @PostConstruct
    public void authenticate() {
        HttpHeaders headersKeycloak = new HttpHeaders();
        headersKeycloak.add("Content-type", "application/x-www-form-urlencoded");

        MultiValueMap<String, String> authData = new LinkedMultiValueMap<>();
        authData.add("client_id", CLIENT_ID);
        authData.add("username", USERNAME);
        authData.add("password", PASSWORD);
        authData.add("grant_type", GRANT_TYPE);

        ResponseEntity<ResultAuth> response = restTemplate.exchange(KEYCLOAK_URL,
                HttpMethod.POST,
                new HttpEntity<MultiValueMap<String, String>>(authData, headersKeycloak),
                ResultAuth.class);

        headersService.add("Authorization", "Bearer " + response.getBody().getAccess_token());
        System.out.println(response.getBody().getAccess_token());
    }

    @Async
    @Override
    public CompletableFuture<List<Person>> asyncReleasePerson(Person newPerson) {
        restTemplate.exchange(SERVICE_URL + "/contact", HttpMethod.POST, new HttpEntity<Person>(newPerson, headersService), String.class);
        Person[] persons = restTemplate.exchange(SERVICE_URL + "/contacts", HttpMethod.GET, new HttpEntity<>(headersService), Person[].class).getBody();

        assert persons != null;
        return CompletableFuture.completedFuture(Arrays.asList(persons));
    }
}
