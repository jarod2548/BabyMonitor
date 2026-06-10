package org.babymonitor.Course.model.vraag;

import jakarta.persistence.*;
import org.babymonitor.CTG.ctg.CTGdata;
import org.babymonitor.Course.model.Course;

@Entity
@Table(name = "vraag")
public class Vraag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "tekst")
    private String tekst;
    @Column(name = "volgorde")
    private int volgorde;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ctg_data_id")
    private CTGdata ctgData;

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

    public void setVolgorde(int volgorde) {
        this.volgorde = volgorde;
    }

    public int getVolgorde() {
        return volgorde;
    }

    public void setCtgData(CTGdata ctgData) {
        this.ctgData = ctgData;
    }

    public CTGdata getCtgData() {
        return ctgData;
    }
}
