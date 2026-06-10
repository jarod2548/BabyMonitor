package org.babymonitor.Course.service;

import java.util.List;

import jakarta.persistence.EntityNotFoundException;
import org.babymonitor.Course.model.*;
import org.babymonitor.Course.model.antwoord.Antwoord;
import org.babymonitor.Course.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

  @Transactional
  public void voegAntwoordToe(Long courseID, Antwoord antwoord){
    Course course = courseRepository.findById(courseID)
            .orElseThrow(() ->
                    new EntityNotFoundException("Course not found"));

    course.getAntwoorden().add(antwoord);

    courseRepository.save(course);
  }

  public List<Course> leesCourses() {
    return courseRepository.findByCompleet(true);
  }

  public List<Course> leesAlleCourses() {
    return courseRepository.findAll();
  }

  public Course leesCourseLazy(Long courseID) {
    Course result = courseRepository.getReferenceById(courseID);
    return result;
  }


  public void linkantwoordentocourse(Long courseID, Long antwoordID) {
    Course course =
        courseRepository
            .findById(courseID)
            .orElseThrow(() -> new RuntimeException("Course not found"));
    Antwoord antwoord =
        antwoordRepository
            .findById(antwoordID)
            .orElseThrow(() -> new RuntimeException("Antwoord not found"));

    // Link
    if (!course.getAntwoorden().contains(antwoord)) {
      course.getAntwoorden().add(antwoord);
      courseRepository.save(course);
    }
  }
}
