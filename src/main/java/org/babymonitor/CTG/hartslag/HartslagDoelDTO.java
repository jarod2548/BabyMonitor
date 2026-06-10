package org.babymonitor.CTG.hartslag;

public class HartslagDoelDTO {
    private int aantal;
    private int tijdDuratie;
    private int varibiliteit;

    public HartslagDoelDTO(){}

    public void setAantal(int aantal) {
        this.aantal = aantal;
    }

    public void setTijdDuratie(int tijdDuratie) {
        this.tijdDuratie = tijdDuratie;
    }

    public void setVaribiliteit(int varibiliteit) {
        this.varibiliteit = varibiliteit;
    }

    public int getAantal() {
        return aantal;
    }

    public int getTijdDuratie() {
        return tijdDuratie;
    }

    public int getVaribiliteit() {
        return varibiliteit;
    }
}
