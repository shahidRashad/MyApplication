package com.example.myapplication;

public class CourseModel {

    private String courseName;
    private String courseDeuration;
    private String courseTrack;
    private String courseDescription;
    private int id;

    public CourseModel(String courseName, String courseDeuration, String courseTrack, String courseDescription) {
        this.courseName = courseName;
        this.courseDeuration = courseDeuration;
        this.courseTrack = courseTrack;
        this.courseDescription = courseDescription;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDeuration() {
        return courseDeuration;
    }

    public void setCourseDeuration(String courseDeuration) {
        this.courseDeuration = courseDeuration;
    }

    public String getCourseTrack() {
        return courseTrack;
    }

    public void setCourseTrack(String courseTrack) {
        this.courseTrack = courseTrack;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
