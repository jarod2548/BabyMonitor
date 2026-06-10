package org.babymonitor.connection.service;

import org.babymonitor.CTG.hartslag.HartslagDoelDTO;
import org.babymonitor.CTG.wee.WeeDoelDTO;
import org.babymonitor.connection.model.Groep;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ConnectionService {
  private final Map<String, Groep> groepen = new ConcurrentHashMap<>();


  public List<Groep> getAlleGroepen() {
    return new ArrayList<>(groepen.values());
  }

  public Groep getOrThrow(String groepId) {
    Groep groep = groepen.get(groepId);
    if (groep == null) {
      throw new IllegalArgumentException("Groep bestaat niet: " + groepId);
    }
    return groep;
  }

  public void updateHartslag(String groepId, HartslagDoelDTO hartslagDoelDTO) {
    Groep groep = getOrThrow(groepId);
    groep.setHartslagDoel(hartslagDoelDTO.getAantal(), hartslagDoelDTO.getTijdDuratie());
  }

  public void updateWee(String groepId, WeeDoelDTO weeDoelDTO){
    Groep groep = getOrThrow(groepId);
    groep.startWee(weeDoelDTO);
  }

  public Groep maakGroep(String naam) {
    String groepId = UUID.randomUUID().toString();
    Groep groep = new Groep(groepId, naam, "");
    groepen.put(groepId, groep);
    return groep;
  }

}
