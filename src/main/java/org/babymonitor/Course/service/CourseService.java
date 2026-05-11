package org.babymonitor.Course.service;

import org.babymonitor.Course.model.Course;
import org.babymonitor.Course.model.*;
import org.babymonitor.Course.repository.*;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final AntwoordRepository antwoordRepository;

    public CourseService(CourseRepository courseRepository, AntwoordRepository antwoordRepository) {
        this.courseRepository = courseRepository;
        this.antwoordRepository = antwoordRepository;
    }

    public Course maakCourse(Course model) {
        Course saved = courseRepository.save(model);
        return saved;
    }

    public Course leesCourseLazy(Long courseID) {
        Course result = courseRepository.getReferenceById(courseID);
        return result;
    }

    public void linkantwoordentocourse(Long courseID, Long antwoordID) {
        Course course = courseRepository.findById(courseID)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        Antwoord antwoord = antwoordRepository.findById(antwoordID)
                .orElseThrow(() -> new RuntimeException("Antwoord not found"));

        // Link
        if (!course.getAntwoorden().contains(antwoord)) {
            course.getAntwoorden().add(antwoord);
            courseRepository.save(course);
        }
    }
}
