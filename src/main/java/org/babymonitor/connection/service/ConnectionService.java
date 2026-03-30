package org.babymonitor.connection.service;

import org.babymonitor.Groep.model.Groep;
import org.babymonitor.Groep.service.GroepService;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.Set;

@Service
public class ConnectionService {
    private final ConcurrentMap<String, Set<String>> groepSessies = new ConcurrentHashMap<>();
    private final GroepService groepService;

    public ConnectionService(GroepService groepService) {
        this.groepService = groepService;
        for (String groepId : groepService.getAlleGroepIds()) {
            groepSessies.put(groepId, ConcurrentHashMap.newKeySet());
        }
    }

    public void voegToeAanGroep(String groepID, String sessieID){
        if (!groepService.bestaatGroep(groepID)) {
            return;
        }

        groepSessies.computeIfAbsent(groepID, key -> ConcurrentHashMap.newKeySet()).add(sessieID);
    }

    public String maakGroepSessie(String sessieID){
        Groep groep = groepService.maakGroep(null);
        Set<String> nieuweSessies = ConcurrentHashMap.newKeySet();
        nieuweSessies.add(sessieID);
        groepSessies.put(groep.getId(), nieuweSessies);
        return groep.getId();
    }


}
