package org.babymonitor.Course.model.antwoord;

public class AntwoordMetStatus {
    private Long antwoordId;
    private String tekst;
    private boolean gekoppeld;

    public AntwoordMetStatus(Long antwoordId, String tekst, boolean gekoppeld){
        this.antwoordId = antwoordId;
        this.tekst = tekst;
        this.gekoppeld = gekoppeld;
    }

    public Long getAntwoordId() {
        return antwoordId;
    }

    public String getTekst() {
        return tekst;
    }

    public boolean isGekoppeld() {
        return gekoppeld;
    }
}
