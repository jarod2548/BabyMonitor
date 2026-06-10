package org.babymonitor.Course.model.antwoord;

public class AntwoordResponseDTO {

  private String tekst;
  private Long id;

  public AntwoordResponseDTO(Antwoord model) {
    tekst = model.getTekst();
    id = model.getId();
  }

  public String getTekst() {
    return tekst;
  }

  public Long getId() {
    return id;
  }
}
