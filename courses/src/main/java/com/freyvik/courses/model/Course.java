package com.freyvik.courses.model;

public class Course {

    private String name;
    private int duration;
    private String schedule;

    public Course() {
    }

    public Course(String name, int duration, String schedule) {
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

    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getSchedule() {
        return schedule;
    }
    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }
}
