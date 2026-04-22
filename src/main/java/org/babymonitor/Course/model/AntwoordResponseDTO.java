package org.babymonitor.Course.model;

public class AntwoordResponseDTO {

    private String tekst;
    private Long id;

    public AntwoordResponseDTO(Antwoord model){
        tekst = model.getTekst();
        id = model.getId();
    }
}
