package org.babymonitor.Course.model;

import jakarta.validation.constraints.NotNull;

public class AntwoordDTO {

  @NotNull private String tekst;
  @NotNull private Long courseID;

  public Antwoord naarModel() {
    return new Antwoord(tekst);
  }

  public String getTekst() {
    return tekst;
  }

  public void setTekst(String tekst) {
    this.tekst = tekst;
  }

  public void setCourseID(Long courseID) {
    this.courseID = courseID;
  }

  public Long getCourseID() {
    return courseID;
  }
}
