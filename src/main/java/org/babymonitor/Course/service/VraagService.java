package org.babymonitor.Course.service;

import org.babymonitor.Course.model.Course;
import org.babymonitor.Course.model.Vraag;
import org.babymonitor.Course.repository.VraagRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VraagService {

    private final VraagRepository vraagRepository;
    private final CourseService courseService;

    public VraagService(VraagRepository vraagRepository, CourseService courseService) {
        this.vraagRepository = vraagRepository;
        this.courseService = courseService;
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
}
