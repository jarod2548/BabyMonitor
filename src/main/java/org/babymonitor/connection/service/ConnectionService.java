package org.babymonitor.connection.service;

import org.babymonitor.CTGdata;
import org.babymonitor.connection.model.CtgCommand;
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

  public void updateBaseline(String groepId, int value) {
    Groep groep = getOrThrow(groepId);

    groep.getCtgdata().setHartbasis(value);
  }

  public void updateVariability(String groepId, int value) {
    Groep groep = getOrThrow(groepId);

    groep.getCtgdata().setVariabiliteit(value);
  }
  public void triggerContraction(String groepId) {
    Groep groep = getOrThrow(groepId);


    //trigger contraction
  }

  public Groep maakGroep(String naam) {
    String groepId = UUID.randomUUID().toString();
    Groep groep = new Groep(groepId, naam, "");
    groepen.put(groepId, groep);
    return groep;
  }

}
