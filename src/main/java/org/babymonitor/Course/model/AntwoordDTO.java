package org.babymonitor.Course.model;

import jakarta.validation.constraints.NotNull;

public class AntwoordDTO{

    @NotNull
    private String tekst;

    public Antwoord naarModel(){
        return new Antwoord(tekst);
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }
}
