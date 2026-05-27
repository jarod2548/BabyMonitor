package org.babymonitor;

public class CTGdata {
    int hartbasis;
    int variabiliteit;

    public CTGdata(int hartbasis, int variabiliteit){
        this.hartbasis = hartbasis;
        this.variabiliteit = variabiliteit;
    }

    public int getHartbasis() {
        return hartbasis;
    }

    public int getVariabiliteit() {
        return variabiliteit;
    }

    public void setHartbasis(int hartbasis) {
        this.hartbasis = hartbasis;
    }

    public void setVariabiliteit(int variabiliteit) {
        this.variabiliteit = variabiliteit;
    }
}
