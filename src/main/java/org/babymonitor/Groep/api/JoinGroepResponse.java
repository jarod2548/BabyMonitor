package org.babymonitor.Groep.api;

public class JoinGroepResponse {

    private String bericht;
    private String groepId;
    private String naam;

    public JoinGroepResponse() {
    }

    public JoinGroepResponse(String bericht, String groepId, String naam) {
        this.bericht = bericht;
        this.groepId = groepId;
        this.naam = naam;
    }


    public String getBericht() {
        return bericht;
    }

    public void setBericht(String bericht) {
        this.bericht = bericht;
    }

    public String getGroepId() {
        return groepId;
    }

    public void setGroepId(String groepId) {
        this.groepId = groepId;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }
}