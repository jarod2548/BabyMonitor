package org.babymonitor.Groep.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.babymonitor.Groep.model.Groep;
import org.springframework.stereotype.Service;

@Service
public class GroepService {

    private final Map<String, Groep> groepen = new ConcurrentHashMap<>();

    public List<Groep> getAlleGroepen() {
        return new ArrayList<>(groepen.values());
    }

    public Groep maakGroep(String naam) {
        String groepId = UUID.randomUUID().toString();
        String groepNaam = (naam == null || naam.isBlank()) ? "Groep X " : naam;

        // 
        Groep groep = new Groep(groepId, groepNaam, "Instructeur A");

        groepen.put(groepId, groep);
        return groep;
    }

    public boolean bestaatGroep(String groepId) {
        return groepen.containsKey(groepId);
    }
}