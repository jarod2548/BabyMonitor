package org.babymonitor.Course.model;

import jakarta.validation.constraints.NotNull;

public class VraagResponseDTO {
    private Long id;
    private int order;
    private String tekst;
    private Long courseID;

    public VraagResponseDTO(Vraag model){
        id = model.getId();
        tekst = model.getTekst();
        courseID= model.getCourse().getId();
        order = model.getOrder();
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public Long getCourseID() {
        return courseID;
    }

    public void setCourseID(Long courseID) {
        this.courseID = courseID;
    }
}
