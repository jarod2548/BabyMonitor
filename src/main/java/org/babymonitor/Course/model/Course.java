package org.babymonitor.Course.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titel")
    private String titel;

    @ManyToMany
    @JoinTable(name = "courseantwoord", joinColumns = @JoinColumn(name = "course_id"), inverseJoinColumns = @JoinColumn(name = "antwoord_id"))
    private Set<Antwoord> antwoorden = new HashSet<>();

    public Course(String titel) {
        this.titel = titel;
    }

    public Course() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public Set<Antwoord> getAntwoorden() {
        return antwoorden;
    }

    public void setAntwoorden(Set<Antwoord> antwoorden) {
        this.antwoorden = antwoorden;
    }
}
