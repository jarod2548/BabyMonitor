package org.babymonitor.Course.service;

import org.babymonitor.Course.model.Course;
import org.babymonitor.Course.model.Vraag;
import org.babymonitor.Course.repository.VraagRepository;

public class VraagService {

    private final VraagRepository vraagRepository;
    private final CourseService courseService;

    public VraagService(VraagRepository vraagRepository, CourseService courseService) {
        this.vraagRepository = vraagRepository;
        this.courseService = courseService;
    }

    public Vraag maakVraag(Vraag model, Long courseID){
        Course proxy = courseService.leesCourseLazy(courseID);
        model.setCourse(proxy);
        return vraagRepository.save(model);
    }

    public Vraag leesVraagLazy(Long vraagID){
        return vraagRepository.getReferenceById(vraagID);
    }
}
