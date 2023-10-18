package com.freyvik.microservicemain.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class greetingController {

    @GetMapping(value = "greeting", produces = MediaType.TEXT_PLAIN_VALUE)
    public String greet() {
        return "Microservice Spring boot";
    }

    @GetMapping(value = "greeting/{name}", produces = MediaType.TEXT_PLAIN_VALUE)
    public String greet(@PathVariable("name") String name) {
        return "Hello " + name;
    }

    @GetMapping(value = "customGreeting", produces = MediaType.TEXT_PLAIN_VALUE)
    public String greet(@RequestParam("name") String name, @RequestParam("age") Integer age) {
        return "Hello " + name + ". You're " + years + " old.";
    }
}
