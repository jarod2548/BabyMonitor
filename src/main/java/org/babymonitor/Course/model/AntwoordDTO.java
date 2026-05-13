package org.babymonitor.Course.model;

import jakarta.validation.constraints.NotNull;

public class AntwoordDTO {

    @NotNull
    private String tekst;

    @NotNull
    private Long courseId;

    public Antwoord naarModel(){
        return new Antwoord(tekst);
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }
}