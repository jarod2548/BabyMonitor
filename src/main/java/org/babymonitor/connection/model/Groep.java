package org.babymonitor.connection.model;

import org.babymonitor.CTGdata;

public class Groep {

  private String id;
  private String naam;
  private String instructeur;
  private long tijd = 0;
  private CTGdata ctgdata = new CTGdata(120,15);

  public Groep() {}

  public Groep(String id, String naam, String instructeur) {
    this.id = id;
    this.naam = naam;
    this.instructeur = instructeur;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getNaam() {
    return naam;
  }

  public void setNaam(String naam) {
    this.naam = naam;
  }

  public String getInstructeur() {
    return instructeur;
  }

  public void setInstructeur(String instructeur) {
    this.instructeur = instructeur;
  }

  public CTGdata getCtgdata() {
    return ctgdata;
  }

  public void setCtgdata(CTGdata ctgdata) {
    this.ctgdata = ctgdata;
  }

  public long getTijd() {
    return tijd;
  }

  public void setTijd(long tijd) {
    this.tijd = tijd;
  }
}
