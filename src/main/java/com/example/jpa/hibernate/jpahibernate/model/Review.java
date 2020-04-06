package com.example.jpa.hibernate.jpahibernate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Review {
    @Id
    @GeneratedValue
    private long id;
    @NotEmpty
    private long course;
    @NotEmpty
    private long student;
    @NotEmpty
    private int rate;
    private String details;

    public Review() {
    }

    public long getId() {
        return id;
    }

    public long getCourse() {
        return course;
    }

    public void setCourse(long course) {
        this.course = course;
    }

    public long getStudent() {
        return student;
    }

    public void setStudent(long student) {
        this.student = student;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", course=" + course +
                ", student=" + student +
                ", rate=" + rate +
                ", details='" + details + '\'' +
                '}';
    }
}
