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

    public void setVraagId(Long vraagId) {
        this.vraagId = vraagId;
    }

    public String getVraagTekst() {
        return vraagTekst;
    }

    public void setVraagTekst(String vraagTekst) {
        this.vraagTekst = vraagTekst;
    }

    public Long getAntwoordId() {
        return antwoordId;
    }

    public void setAntwoordId(Long antwoordId) {
        this.antwoordId = antwoordId;
    }

    public String getAntwoordTekst() {
        return antwoordTekst;
    }

    public void setAntwoordTekst(String antwoordTekst) {
        this.antwoordTekst = antwoordTekst;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }
}