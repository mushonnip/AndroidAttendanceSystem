package id.abu.sistemabsensipolindra.models;

import java.util.List;

public class Schedule {
    private String course;
    private String active_day;
    private String class_room;
    private String start_at;
    private String end_at;

    public Schedule(String course, String active_day, String class_room, String start_at, String end_at) {
        this.course = course;
        this.active_day = active_day;
        this.class_room = class_room;
        this.start_at = start_at;
        this.end_at = end_at;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getActive_day() {
        return active_day;
    }

    public void setActive_day(String active_day) {
        this.active_day = active_day;
    }

    public String getClass_room() {
        return class_room;
    }

    public void setClass_room(String class_room) {
        this.class_room = class_room;
    }

    public String getStart_at() {
        return start_at;
    }

    public void setStart_at(String start_at) {
        this.start_at = start_at;
    }

    public String getEnd_at() {
        return end_at;
    }

    public void setEnd_at(String end_at) {
        this.end_at = end_at;
    }

}
