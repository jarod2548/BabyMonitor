package org.babymonitor.Course.repository;

import java.util.Optional;

import org.babymonitor.Course.model.VraagAntwoord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VraagAntwoordRepository
        extends JpaRepository<VraagAntwoord, Long> {

    Optional<VraagAntwoord>
    findByVraag_IdAndAntwoord_Id(Long vraagId,
                                 Long antwoordId);
}