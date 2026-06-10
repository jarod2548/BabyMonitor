package org.babymonitor.Course.repository;

import org.babymonitor.Course.model.vraag.VraagAntwoord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VraagAntwoordRepository extends JpaRepository<VraagAntwoord, Long> {

    boolean existsByVraag_IdAndAntwoord_Id(Long vraagId, Long antwoordId);
    List<VraagAntwoord> findByVraag_Id(Long vraagId);
}