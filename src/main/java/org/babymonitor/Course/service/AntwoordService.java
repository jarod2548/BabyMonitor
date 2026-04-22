package org.babymonitor.Course.service;

import org.babymonitor.Course.model.Antwoord;
import org.babymonitor.Course.model.Vraag;
import org.babymonitor.Course.repository.AntwoordRepository;

public class AntwoordService {

    private final AntwoordRepository antwoordRepository;
    private final VraagService vraagService;

    public AntwoordService(AntwoordRepository antwoordRepository, VraagService vraagService) {
        this.antwoordRepository = antwoordRepository;
        this.vraagService = vraagService;
    }

    public Antwoord maakAntwoord(Antwoord model, Long vraagID){
        Vraag proxy = vraagService.leesVraagLazy(vraagID);
        model.setVraag(proxy);
        return antwoordRepository.save(model);
    }
}
