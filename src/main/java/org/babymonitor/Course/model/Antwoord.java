package org.babymonitor.Course.model;

import jakarta.persistence.*;

@Entity
@Table(name = "antwoord")
public class Antwoord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "tekst")
    private String tekst;
    @ManyToOne
    @JoinColumn(name = "course")
    private Course course;

    public Antwoord(String Tekst){
        tekst = Tekst;
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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
