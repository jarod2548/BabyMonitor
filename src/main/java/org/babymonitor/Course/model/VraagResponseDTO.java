package org.babymonitor.Course.model;

import org.babymonitor.CTGdata;
import org.babymonitor.Course.api.CTGdataDTO;

public class VraagResponseDTO {
    private Long id;
    private int order;
    private String tekst;
    private Long courseID;
    private CTGdataDTO ctgData;

    public VraagResponseDTO(Vraag model){
        id = model.getId();
        tekst = model.getTekst();
        courseID= model.getCourse().getId();
        order = model.getVolgorde();
        ctgData = new CTGdataDTO(100, 10);
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

    public CTGdataDTO getCtgData() {
        return ctgData;
    }

    public Long getId() {
        return id;
    }
}
