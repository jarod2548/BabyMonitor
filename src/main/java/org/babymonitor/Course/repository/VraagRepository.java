package org.babymonitor.Course.repository;

import org.babymonitor.Course.model.Vraag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface VraagRepository extends JpaRepository<Vraag, Long> {
    long countByCourse_Id(Long courseID);
    List<Vraag> findByCourse_IdOrderByOrderAsc(Long courseID);
}
