package org.babymonitor.Course.model;

import jakarta.persistence.*;

@Entity
@Table(name = "vraag_antwoord")
public class VraagAntwoord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vraag_id")
    private Vraag vraag;

    @ManyToOne
    @JoinColumn(name = "antwoord_id")
    private Antwoord antwoord;

    public VraagAntwoord() {}

    public VraagAntwoord(Vraag vraag, Antwoord antwoord) {
        this.vraag = vraag;
        this.antwoord = antwoord;
    }

    public Long getId() {
        return id;
    }

    public Vraag getVraag() {
        return vraag;
    }

    public void setVraag(Vraag vraag) {
        this.vraag = vraag;
    }

    public Antwoord getAntwoord() {
        return antwoord;
    }

    public void setAntwoord(Antwoord antwoord) {
        this.antwoord = antwoord;
    }
}