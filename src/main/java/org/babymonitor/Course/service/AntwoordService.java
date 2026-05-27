package org.babymonitor.Course.service;

import java.util.List;
import org.babymonitor.Course.model.Antwoord;
import org.babymonitor.Course.repository.AntwoordRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AntwoordService {

  private final AntwoordRepository antwoordRepository;
    private final CourseService courseService;

    public AntwoordService(AntwoordRepository antwoordRepository, CourseService courseService) {
    this.antwoordRepository = antwoordRepository;
        this.courseService = courseService;
    }

    @Transactional
  public Antwoord maakAntwoord(Antwoord model, Long courseID) {
      Antwoord saved = antwoordRepository.save(model);

      courseService.voegAntwoordToe(courseID, saved);

      return saved;
  }

  public List<Antwoord> leesAntwoordenVanCourse(Long courseId) {
    return antwoordRepository.findByCourses_Id(courseId);
  }
}
