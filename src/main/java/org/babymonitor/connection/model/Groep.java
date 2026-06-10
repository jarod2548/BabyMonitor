package org.babymonitor.connection.model;

import org.babymonitor.CTG.AcceleratieType;
import org.babymonitor.CTG.ctg.CTGdata;
import org.babymonitor.CTG.wee.WeeDoelDTO;
import org.babymonitor.CTG.wee.WeeStatus;

public class Groep {

  private String id;
  private String naam;
  private String instructeur;
  private long tijd = 0;
  private CTGdata ctgdata = new CTGdata(120,15);
  private WeeStatus weeStatus = new WeeStatus(60,60, AcceleratieType.VROEG);

  private int hartslagDoel;
  private int tijdOver;

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

  public int getHartslagDoel() {
    return hartslagDoel;
  }

  public int getTijdOver() {
    return tijdOver;
  }

  public WeeStatus getWeeStatus() {
    return weeStatus;
  }

  public void setHartslagDoel(int hartslagDoel, int tijdOver) {
    this.hartslagDoel = hartslagDoel;
    this.tijdOver = tijdOver;
  }
  public void startWee(WeeDoelDTO doelDTO){
    weeStatus.setValues(doelDTO);
  }

  public void tick()
  {
    tijd ++;
  }

  public void tickHartslagTransactie(){
    if(tijdOver <= 0) {
      ctgdata.setHartbasis(hartslagDoel);
      return;
    }
    tijdOver -=1;
  }


}
