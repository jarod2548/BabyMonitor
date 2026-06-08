package org.babymonitor.connection.api;

import org.babymonitor.connection.model.Groep;

public class MaakGroepResponse {
    private String naam;
    private String id;

    public MaakGroepResponse() {}
    public MaakGroepResponse(Groep groep){
        naam = groep.getNaam();
        id = groep.getId();
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
