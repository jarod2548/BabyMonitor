package org.babymonitor.Course.model;

import jakarta.validation.constraints.NotNull;

public class VraagAntwoordDTO {

    @NotNull
    private Long vraagId;

    @NotNull
    private Long antwoordId;

    public Long getVraagId() {
        return vraagId;
    }

    public void setVraagId(Long vraagId) {
        this.vraagId = vraagId;
    }

    public Long getAntwoordId() {
        return antwoordId;
    }

    public void setAntwoordId(Long antwoordId) {
        this.antwoordId = antwoordId;
    }
}