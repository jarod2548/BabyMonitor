package org.babymonitor.Course.service;

import org.babymonitor.Course.model.Course;
import org.babymonitor.Course.repository.CourseRepository;

public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course maakCourse(Course model){
        Course saved = courseRepository.save(model);
        return saved;
    }

    public Course leesCourseLazy(Long courseID){
        Course result = courseRepository.getReferenceById(courseID);
        return result;
    }
}
