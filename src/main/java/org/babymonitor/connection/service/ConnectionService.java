package org.babymonitor.connection.service;

import org.babymonitor.Groep.model.Groep;
import org.babymonitor.Groep.service.GroepService;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.Set;

@Service
public class ConnectionService {

    private final GroepService groepService;

    public ConnectionService(GroepService groepService) {
        this.groepService = groepService;
    }
}
