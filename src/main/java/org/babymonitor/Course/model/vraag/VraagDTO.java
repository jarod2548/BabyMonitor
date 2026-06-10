package org.babymonitor.Course.model.vraag;

import jakarta.validation.constraints.NotNull;
import org.babymonitor.CTG.ctg.CTGdataDTO;

public class VraagDTO {
  @NotNull private String tekst;
  @NotNull private Long courseID;
  @NotNull private CTGdataDTO ctgData;

  public Vraag naarModel() {
    return new Vraag(tekst);
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

  public CTGdataDTO getCtgData() {
    return ctgData;
  }

  public void setCtgData(CTGdataDTO ctgData) {
    this.ctgData = ctgData;
  }
}
