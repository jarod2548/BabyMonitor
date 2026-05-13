package org.babymonitor.Course.model;

public class VraagAntwoordResponseDTO {

    private Long vraagId;
    private String vraagTekst;

    private Long antwoordId;
    private String antwoordTekst;

    private boolean correct;

    public VraagAntwoordResponseDTO(VraagAntwoord model){

        vraagId = model.getVraag().getId();
        vraagTekst = model.getVraag().getTekst();

        antwoordId = model.getAntwoord().getId();
        antwoordTekst = model.getAntwoord().getTekst();

        correct = model.isCorrect();
    }

    public Long getVraagId() {
        return vraagId;
    }

    public String getVraagTekst() {
        return vraagTekst;
    }

    public Long getAntwoordId() {
        return antwoordId;
    }

    public String getAntwoordTekst() {
        return antwoordTekst;
    }

    public boolean isCorrect() {
        return correct;
    }
}