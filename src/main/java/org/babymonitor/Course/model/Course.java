package org.babymonitor.Course.model;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titel")
    private String titel;

    public Course(String Titel)
    {
        this.titel = Titel;
    }

    public Course(){}


    public String getTitel() {
        return titel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }
}
