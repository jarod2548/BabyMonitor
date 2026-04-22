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
    @JoinColumn(name = "vraag")
    private Vraag vraag;

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

    public void setVraag(Vraag vraag) {
        this.vraag = vraag;
    }

    public Vraag getVraag() {
        return vraag;
    }
}
