package org.babymonitor.Course.model;

import org.babymonitor.CTGdata;

public class VraagResponseDTO {
    private Long id;
    private int order;
    private String tekst;
    private Long courseID;
    private CTGdata ctgData;

    public VraagResponseDTO(Vraag model){
        id = model.getId();
        tekst = model.getTekst();
        courseID= model.getCourse().getId();
        order = model.getVolgorde();
        ctgData = new CTGdata(100, 10);
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

    public int getOrder() {
        return order;
    }

    public CTGdata getCtgData() {
        return ctgData;
    }

    public Long getId() {
        return id;
    }
}
