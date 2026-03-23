package org.babymonitor.connection.service;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

@Service
public class ConnectionService {
    private final Map<String, Set<String>> groepSessies = new ConcurrentHashMap<>();

    public void voegToeAanGroep(String groepID, String sessieID){
        Set<String> sessies = groepSessies.get(groepID);
        if(sessies != null){
            sessies.add(sessieID);
        }
    }

    public String maakGroepSessie(String sessieID){
        String groepID = UUID.randomUUID().toString();
        Set<String> nieuweSessies = new HashSet<>();
        nieuweSessies.add(sessieID);
        groepSessies.put(groepID, nieuweSessies);
        return groepID;
    }

    public void verwijderVanGroep(String groepID, String sessieID) {
        Set<String> sessies = groepSessies.get(groepID);
        if (sessies != null) {
            sessies.remove(sessieID);
        }
    }
    
    public Set<String> getGroepIds() {
        return groepSessies.keySet();
    }
}