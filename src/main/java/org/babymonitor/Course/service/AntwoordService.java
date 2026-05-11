package org.babymonitor.Course.service;

import org.babymonitor.Course.model.Antwoord;

import org.babymonitor.Course.repository.AntwoordRepository;
import org.springframework.stereotype.Service;

@Service
public class AntwoordService {

    private final AntwoordRepository antwoordRepository;

    public AntwoordService(AntwoordRepository antwoordRepository) {
        this.antwoordRepository = antwoordRepository;

    }

    public Antwoord maakAntwoord(Antwoord model, Long courseID) {
        return antwoordRepository.save(model);
    }
}
