package org.babymonitor.Course.service;

import org.babymonitor.Course.model.*;
import org.babymonitor.Course.model.antwoord.Antwoord;
import org.babymonitor.Course.model.antwoord.AntwoordMetStatus;
import org.babymonitor.Course.model.vraag.Vraag;
import org.babymonitor.Course.model.vraag.VraagAntwoord;
import org.babymonitor.Course.repository.AntwoordRepository;
import org.babymonitor.Course.repository.VraagAntwoordRepository;
import org.babymonitor.Course.repository.VraagRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class VraagService {

    private final VraagRepository vraagRepository;
    private final CourseService courseService;
    private final VraagAntwoordRepository vraagAntwoordRepository;
    private final AntwoordService antwoordService;
    private final AntwoordRepository antwoordRepository;

    public VraagService(VraagRepository vraagRepository, CourseService courseService, VraagAntwoordRepository vraagAntwoordRepository, AntwoordService antwoordService, AntwoordRepository antwoordRepository) {
        this.vraagRepository = vraagRepository;
        this.courseService = courseService;
        this.vraagAntwoordRepository = vraagAntwoordRepository;
        this.antwoordService = antwoordService;
        this.antwoordRepository = antwoordRepository;
    }

    public Vraag maakVraag(Vraag model, Long courseID){
        Course proxy = courseService.leesCourseLazy(courseID);
        int currentCount = (int)vraagRepository.countByCourse_Id(proxy.getId());
        model.setCourse(proxy);
        model.setVolgorde(currentCount + 1);

        return vraagRepository.save(model);
    }

    public Vraag leesVraag(Long courseID, int order){
        Vraag resultaat = vraagRepository.findByCourse_IdAndVolgorde(courseID,order);
        return resultaat;
    }
    public Vraag leesVraag(Long vraagId){
        return vraagRepository.findById(vraagId)
                .orElseThrow(() -> new RuntimeException("Geen vraag gevonden"));
    }

    public List<Vraag> leesVragen(Long courseID){
        return vraagRepository.findByCourse_Id(courseID);
    }

    public VraagAntwoord maakVraagAntwoord(Long vraagId, Long antwoordId) {

    Vraag vraag = vraagRepository.getReferenceById(vraagId);
    Antwoord antwoord = antwoordRepository.getReferenceById(antwoordId);
    VraagAntwoord vraagAntwoord = new VraagAntwoord(vraag, antwoord);

    return vraagAntwoordRepository.save(vraagAntwoord);
}
    public List<AntwoordMetStatus> leesVraagAntwoorden(Long vraagId, Long courseId){
        List<AntwoordMetStatus> resultaten = new ArrayList<>();
         List<VraagAntwoord> vraagAntwoords = vraagAntwoordRepository.findByVraag_Id(vraagId);
         List<Antwoord> antwoorden = antwoordService.leesAntwoordenVanCourse(courseId);
        Set<Long> gekoppeldeAntwoordIds = vraagAntwoords.stream()
                .map(va -> va.getAntwoord().getId())
                .collect(Collectors.toSet());
        for (Antwoord antwoord : antwoorden) {
            boolean gekoppeld =
                    gekoppeldeAntwoordIds.contains(antwoord.getId());
            resultaten.add(new AntwoordMetStatus(antwoord.getId(),
                    antwoord.getTekst(),
                    gekoppeld));
        }
        return resultaten;
    }


public boolean controleerAntwoord(Long vraagId, Long antwoordId){

    return vraagAntwoordRepository.existsByVraag_IdAndAntwoord_Id(vraagId, antwoordId);
}
}