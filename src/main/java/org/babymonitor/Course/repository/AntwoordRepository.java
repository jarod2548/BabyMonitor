package org.babymonitor.Course.repository;

import org.babymonitor.Course.model.Antwoord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AntwoordRepository extends JpaRepository<Antwoord, Long> {
}
