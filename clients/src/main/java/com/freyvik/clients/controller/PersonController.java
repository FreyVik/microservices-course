package com.freyvik.clients.controller;

import com.freyvik.clients.model.Person;
import com.freyvik.clients.service.AccessService;
import com.freyvik.clients.service.AccessServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
public class PersonController {

    @Autowired
    AccessService accessService;

    @GetMapping(value = "/person/{name}/{email}/{age}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> releasePerson(
            @PathVariable("name") String name,
            @PathVariable("email") String email,
            @PathVariable("age") int age
    ) {
        Person newPerson = new Person(name, email, age);

        CompletableFuture<List<Person>> result = accessService.asyncReleasePerson(newPerson);

        /*
        for (int i = 0; i < 50; i ++) {
            System.out.println("Waiting...");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }*/

        try {
            return result.get();
        } catch (InterruptedException | ExecutionException e) {
            return null;
        }
    }
}
