package org.babymonitor.Course.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "antwoord")
public class Antwoord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tekst")
    private String tekst;

    @ManyToMany(mappedBy = "antwoorden")
    private Set<Course> courses = new HashSet<>();

    public Antwoord(String Tekst) {
        tekst = Tekst;
    }

    public Antwoord() {
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public String getTekst() {
        return tekst;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
