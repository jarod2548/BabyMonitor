package connection.service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

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

    public void verwijderVanGroep(String groepID, String sessieID){
        Set<String> sessies = groepSessies.get(groepID);
        if(sessies != null){
            sessies.remove(sessieID);
        }
    }

}
