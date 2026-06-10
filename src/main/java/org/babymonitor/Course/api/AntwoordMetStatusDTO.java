package org.babymonitor.Course.api;

import org.babymonitor.Course.model.antwoord.AntwoordMetStatus;

public class AntwoordMetStatusDTO {
    private Long antwoordId;
    private String tekst;
    private boolean gekoppeld;

    public AntwoordMetStatusDTO(){}
    public AntwoordMetStatusDTO(AntwoordMetStatus model){
        antwoordId = model.getAntwoordId();
        tekst = model.getTekst();
        gekoppeld = model.isGekoppeld();
    }

    public String getTekst() {
        return tekst;
    }

    public Long getAntwoordId() {
        return antwoordId;
    }

    public boolean isGekoppeld() {
        return gekoppeld;
    }
}
