package org.babymonitor.Course.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "vraag")
public class Vraag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "tekst")
    private String tekst;
    @Column(name = "order")
    private int order;
    @ManyToOne
    @JoinColumn(name = "course")
    private Course course;

    public Vraag(String Tekst){
        tekst = Tekst;
    }

    public Vraag(){}

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Course getCourse() {
        return course;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getOrder() {
        return order;
    }
}
