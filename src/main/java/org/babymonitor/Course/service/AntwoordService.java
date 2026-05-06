package org.babymonitor.Course.service;

import org.babymonitor.Course.model.Antwoord;
import org.babymonitor.Course.model.Course;
import org.babymonitor.Course.model.Vraag;
import org.babymonitor.Course.repository.AntwoordRepository;
import org.springframework.stereotype.Service;

@Service
public class AntwoordService {

    private final AntwoordRepository antwoordRepository;
    private final CourseService courseService;

    public AntwoordService(AntwoordRepository antwoordRepository, CourseService courseService) {
        this.antwoordRepository = antwoordRepository;
        this.courseService = courseService;
    }

    public Antwoord maakAntwoord(Antwoord model, Long courseID){
        Course proxy = courseService.leesCourseLazy(courseID);
        model.setCourse(proxy);
        return antwoordRepository.save(model);
    }
}
