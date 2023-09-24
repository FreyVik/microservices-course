package com.freyvik.mainmicroservice.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @GetMapping(value = "greeting", produces = MediaType.TEXT_PLAIN_VALUE)
    public String greeting() {
        return "SpringBoot microservice";
    }

    @GetMapping(value = "greeting/{name}", produces = MediaType.TEXT_PLAIN_VALUE)
    public String customGreeting(@PathVariable String name) {
        return "Hello ".concat(name.toUpperCase()).concat(" welcome to the main microservice");
    }

    @GetMapping(value = "customGreeting", produces = MediaType.TEXT_PLAIN_VALUE)
    public String customGreeting(@RequestParam("name") String name, @RequestParam(name = "age", required = false) Integer age) {
        return "Hello ".concat(name.toUpperCase()).concat(" welcome to the main microservice.\n")
                .concat("You're ")
                .concat(Integer.toString((age != null) ? age : 0))
                .concat(" years old.");
    }
}
