package com.freyvik.clients.service;

import com.freyvik.clients.model.Person;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface AccessService {

    public CompletableFuture<List<Person>> asyncReleasePerson(Person newPerson);

}
