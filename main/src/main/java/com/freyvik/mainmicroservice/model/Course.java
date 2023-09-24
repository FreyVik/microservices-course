package com.freyvik.mainmicroservice.model;

public class Course {

    private String name;
    private Integer duration;
    private String schedule;

    public Course(String name, Integer duration, String schedule) {
        this.name = name;
        this.duration = duration;
        this.schedule = schedule;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Integer getDuration() {
        return duration;
    }
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getSchedule() {
        return schedule;
    }
    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }
}
