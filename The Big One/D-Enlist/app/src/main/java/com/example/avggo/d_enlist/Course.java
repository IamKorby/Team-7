package com.example.avggo.d_enlist;

/**
 * Created by kevin on 4/5/2016.
 */
public class Course {

    public static final String TABLE_NAME             = "course";
    public static final String COLUMN_CLASS_NUMBER    = "classNumber";
    public static final String COLUMN_COURSE_NAME     = "courseName";
    public static final String COLUMN_SECTION         = "section";
    public static final String COLUMN_DAYS            = "days";
    public static final String COLUMN_START_TIME      = "startTime";
    public static final String COLUMN_END_TIME        = "endTime";
    public static final String COLUMN_ROOM            = "room";
    public static final String COLUMN_PROFESSOR       = "professor";
    public static final String COLUMN_ENROLL_CAPACITY = "enrollCapacity";
    public static final String COLUMN_ENROLLED        = "enrolled";

    String classNumber;
    String courseName;
    String section;
    String days;
    String startTime;
    String endTime;
    String room;
    String professor;
    int enrollCapacity;
    int enrolled;

    public Course() {
        this.classNumber = "";
        this.courseName = "";
        this.section = "";
        this.startTime = "";
        this.days = "";
        this.endTime = "";
        this.room = "";
        setEnrollCapacity(0);
        this.professor = "";
        setEnrolled(0);
    }

    public Course(String classNumber, String courseName, String section, String days, String startTime,
                  String endTime, String room, String professor, int enrollCapacity, int enrolled) {
        this.classNumber = classNumber;
        this.courseName = courseName;
        this.section = section;
        this.startTime = startTime;
        this.days = days;
        this.endTime = endTime;
        this.room = room;
        //this.enrollCapacity = enrollCapacity;
        setEnrollCapacity(enrollCapacity);
        this.professor = professor;
        //this.enrolled = enrolled;
        setEnrolled(enrolled);
    }

    public String getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public int getEnrolled() {
        return enrolled;
    }

    public void setEnrolled(int enrolled) {
        if (enrolled == 0 && enrolled > this.enrollCapacity)
            this.enrolled = 0;

        this.enrolled = enrolled;
    }

    public int getEnrollCapacity() {
        return enrollCapacity;
    }

    public void setEnrollCapacity(int enrollCapacity) {
        if (enrollCapacity < 0)
            this.enrollCapacity = 0;

        this.enrollCapacity = enrollCapacity;
    }
}
