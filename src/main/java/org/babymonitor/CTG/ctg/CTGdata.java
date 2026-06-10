package org.babymonitor.CTG.ctg;

import jakarta.persistence.*;

@Entity
@Table(name = "ctg_data")
public class CTGdata {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "hartbasis")
    private int hartbasis;
    @Column(name = "variabiliteit")
    private int variabiliteit;

    public CTGdata(int hartbasis, int variabiliteit){
        this.hartbasis = hartbasis;
        this.variabiliteit = variabiliteit;
    }

    public CTGdata(){}

    public int getHartbasis() {
        return hartbasis;
    }

    public int getVariabiliteit() {
        return variabiliteit;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setHartbasis(int hartbasis) {
        this.hartbasis = hartbasis;
    }

    public void setVariabiliteit(int variabiliteit) {
        this.variabiliteit = variabiliteit;
    }

    public int getId() {
        return id;
    }
}
