package com.freyvik.courses.controllers;

import com.freyvik.courses.model.Course;
import jakarta.annotation.PostConstruct;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CourseController {

    private List<Course> courses;

    @PostConstruct
    public void init() {
        courses = new ArrayList<>();

        courses.add(new Course("Java", 100, "Morning"));
        courses.add(new Course("Spring", 20, "Evening"));
        courses.add(new Course("Python", 25, "Afternoon"));
        courses.add(new Course("Angular", 50, "Weekend"));
        courses.add(new Course("Java expert", 75, "Morning"));
    }

    @GetMapping(value = "course", produces = MediaType.APPLICATION_JSON_VALUE)
    public Course getCourse() {
        return new Course("Java", 100, "Morning");
    }

    @GetMapping(value = "courses", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Course> getCourses() {
        return courses;
    }

    @GetMapping(value = "findCourse/{course}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Course> findCourse(@PathVariable("course") String courseName) {
        return courses.stream()
                .filter(course -> course.getName().contains(courseName))
                .collect(Collectors.toList());
    }

    @DeleteMapping(value = "course/{course}")
    public void deleteCourse(@PathVariable("course") String courseName) {
        courses.removeIf(c -> c.getName().equals(courseName));
    }

    @PostMapping(value = "course", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Course> newCourse(@RequestBody Course course) {
        courses.add(course);

        return courses;
    }

    @PutMapping(value = "course", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Course> updateCourse(@RequestBody Course course) {
        for(int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getName().equals(course.getName())) {
                courses.set(i, course);
            }
        }

        return courses;
    }
}
