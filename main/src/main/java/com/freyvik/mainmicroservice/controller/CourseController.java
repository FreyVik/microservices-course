package com.freyvik.mainmicroservice.controller;

import com.freyvik.mainmicroservice.model.Course;
import jakarta.annotation.PostConstruct;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    List<Course> courses;
    Course defaultCourse;

    @PostConstruct
    public void init() {
        this.courses = List.of(
                new Course("Spring", 25, "Evening"),
                new Course("Spring boot", 20, "Evening"),
                new Course("Python", 30, "Evening"),
                new Course("Java EE", 50, "Weekend"),
                new Course("Basic Java", 30, "Morning")
        );

        this.defaultCourse = new Course("Default", 30, "Never");
    }

    @GetMapping(value = "course",  produces = MediaType.APPLICATION_JSON_VALUE)
    public Course getCourse() {
        return new Course("Java", 100, "Mondays");
    }

    @GetMapping(value = "courses", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Course> getCourses() {
        return this.courses;
    }

    @GetMapping(value = "course/{name}",  produces = MediaType.APPLICATION_JSON_VALUE)
    public Course getFindedCourse(@PathVariable("name") String name) {
        return courses.stream()
                .filter(persona -> name.equals(persona.getName()))
                .findFirst()
                .orElse(defaultCourse);
    }
}
