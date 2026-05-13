package org.babymonitor.Course.service;

import java.util.List;

import org.babymonitor.Course.model.Antwoord;
import org.babymonitor.Course.model.Course;
import org.babymonitor.Course.model.Vraag;
import org.babymonitor.Course.model.VraagAntwoord;
import org.babymonitor.Course.repository.AntwoordRepository;
import org.babymonitor.Course.repository.VraagAntwoordRepository;
import org.babymonitor.Course.repository.VraagRepository;
import org.springframework.stereotype.Service;

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

    public Vraag maakVraag(Vraag model){
        Course proxy = courseService.leesCourseLazy(model.getCourseID());
        int currentCount = (int)vraagRepository.countByCourse_Id(proxy.getId());
        model.setCourse(proxy);
        model.setOrder(currentCount + 1);

        return vraagRepository.save(model);
    }

    public List<Vraag> leesVragen(Long courseID){
        List<Vraag> resultaten = vraagRepository.findByCourse_IdOrderByOrderAsc(courseID);
        return resultaten;
    }

    public Vraag leesVraagLazy(Long vraagID){
        return vraagRepository.getReferenceById(vraagID);
    }

    public VraagAntwoord maakVraagAntwoord(Long vraagId,
                                       Long antwoordId,
                                       boolean correct) {

    Vraag vraag = vraagRepository.getReferenceById(vraagId);

    Antwoord antwoord =
            antwoordRepository.getReferenceById(antwoordId);

    VraagAntwoord vraagAntwoord =
            new VraagAntwoord(vraag, antwoord);

    vraagAntwoord.setCorrect(correct);

    return vraagAntwoordRepository.save(vraagAntwoord);
}

public boolean controleerAntwoord(Long vraagId,
                                  Long antwoordId){

    VraagAntwoord vraagAntwoord =
            vraagAntwoordRepository
                    .findByVraag_IdAndAntwoord_Id(
                            vraagId,
                            antwoordId
                    )
                    .orElseThrow();

    return vraagAntwoord.isCorrect();
}