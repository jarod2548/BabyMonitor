package org.babymonitor.Groep.model;

public class Groep {

    private String id;
    private String naam;
    private String instructeur; 

    public Groep() {
    }

    public Groep(String id, String naam, String instructeur) { 
        this.id = id;
        this.naam = naam;
        this.instructeur = instructeur;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getInstructeur() { 
        return instructeur;
    }

    public void setInstructeur(String instructeur) { 
        this.instructeur = instructeur;
    }
}
