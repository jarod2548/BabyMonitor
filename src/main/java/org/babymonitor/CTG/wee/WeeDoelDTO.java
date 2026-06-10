package org.babymonitor.CTG.wee;

import org.babymonitor.CTG.AcceleratieType;

public class WeeDoelDTO {
    private int weeSterkte;
    private int weeDuratie;
    private AcceleratieType acceleratieType;

    public WeeDoelDTO(){}

    public int getWeeDuratie() {
        return weeDuratie;
    }

    public int getWeeSterkte() {
        return weeSterkte;
    }

    public void setWeeDuratie(int weeDuratie) {
        this.weeDuratie = weeDuratie;
    }

    public void setWeeSterkte(int weeSterkte) {
        this.weeSterkte = weeSterkte;
    }

    public AcceleratieType getAcceleratieType() {
        return acceleratieType;
    }

    public void setAcceleratieType(AcceleratieType acceleratieType) {
        this.acceleratieType = acceleratieType;
    }

}
