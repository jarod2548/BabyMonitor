package org.babymonitor.Course.service;

import java.util.List;

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

    public List<Antwoord> leesAntwoordenVanCourse(Long courseId) {
        return antwoordRepository.findByCourses_Id(courseId);
    }
}
