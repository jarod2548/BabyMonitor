package org.babymonitor.Course.service;

import org.babymonitor.Course.model.Antwoord;
import org.babymonitor.Course.model.Course;
import org.babymonitor.Course.model.Vraag;
import org.babymonitor.Course.model.VraagAntwoord;
import org.babymonitor.Course.repository.AntwoordRepository;
import org.babymonitor.Course.repository.VraagAntwoordRepository;
import org.babymonitor.Course.repository.VraagRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VraagService {

    private final VraagRepository vraagRepository;
    private final CourseService courseService;
    private final VraagAntwoordRepository vraagAntwoordRepository;
    private final AntwoordRepository antwoordRepository;

    public VraagService(VraagRepository vraagRepository, CourseService courseService, VraagAntwoordRepository vraagAntwoordRepository, AntwoordRepository antwoordRepository) {
        this.vraagRepository = vraagRepository;
        this.courseService = courseService;
        this.vraagAntwoordRepository = vraagAntwoordRepository;
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

    public List<Vraag> leesVragen(Long courseID){
        return vraagRepository.findByCourse_Id(courseID);
    }

    public Vraag leesVraagLazy(Long vraagID){
        return vraagRepository.getReferenceById(vraagID);
    }

    public VraagAntwoord maakVraagAntwoord(Long vraagId, Long antwoordId) {

    Vraag vraag = vraagRepository.getReferenceById(vraagId);
    Antwoord antwoord = antwoordRepository.getReferenceById(antwoordId);
    VraagAntwoord vraagAntwoord = new VraagAntwoord(vraag, antwoord);

    return vraagAntwoordRepository.save(vraagAntwoord);
}

public boolean controleerAntwoord(Long vraagId, Long antwoordId){

    return vraagAntwoordRepository.existsByVraag_IdAndAntwoord_Id(vraagId, antwoordId);
}
}