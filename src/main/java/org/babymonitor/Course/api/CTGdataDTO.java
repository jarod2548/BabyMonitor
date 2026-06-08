package org.babymonitor.Course.api;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.babymonitor.CTGdata;

public class CTGdataDTO {
    @NotNull
    @Min(value = 1)
    private int hartbasis;
    @NotNull
    @Min(value = 1)
    private int variabiliteit;

    public CTGdataDTO(CTGdata data){
        this.hartbasis = data.getHartbasis();
        this.variabiliteit = data.getVariabiliteit();
    }

    public CTGdataDTO(int hartbasis, int variabiliteit){
        this.hartbasis = hartbasis;
        this.variabiliteit = variabiliteit;
    }

    public CTGdataDTO() {
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
