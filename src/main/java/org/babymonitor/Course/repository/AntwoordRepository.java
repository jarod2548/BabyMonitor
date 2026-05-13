package org.babymonitor.Course.repository;

import java.util.List;

import org.babymonitor.Course.model.Antwoord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AntwoordRepository extends JpaRepository<Antwoord, Long> {

    List<Antwoord> findByCourses_Id(Long courseId);

}
