package org.babymonitor.Course.model;

public class VraagAntwoordResponseDTO {

    private Long vraagId;
    private Long antwoordId;


    public VraagAntwoordResponseDTO(VraagAntwoord model){

        vraagId = model.getVraag().getId();
        antwoordId = model.getAntwoord().getId();
    }

    public Long getVraagId() {
        return vraagId;
    }

    public Long getAntwoordId() {
        return antwoordId;
    }

}