package org.babymonitor.Course.api;

import java.util.List;

import org.babymonitor.Course.model.Antwoord;
import org.babymonitor.Course.model.AntwoordDTO;
import org.babymonitor.Course.model.AntwoordResponseDTO;
import org.babymonitor.Course.service.AntwoordService;
import org.babymonitor.Security.UserPrincipal;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.Valid;

@Controller
public class AntwoordController {

    private final AntwoordService antwoordService;

    public AntwoordController(AntwoordService antwoordService) {
        this.antwoordService = antwoordService;
    }

    @PostMapping("/teacher/antwoord")
    public ResponseEntity<AntwoordResponseDTO> maakAntwoord(
            @RequestBody @Valid AntwoordDTO dto,
            @AuthenticationPrincipal UserPrincipal user) {

        Antwoord saved = antwoordService.maakAntwoord(dto.naarModel(), dto.naarModel().getId());

        return ResponseEntity.ok(new AntwoordResponseDTO(saved));
    }

    @GetMapping("/course/{id}/antwoorden")
    public ResponseEntity<List<AntwoordResponseDTO>> leesAntwoorden(
            @PathVariable Long id) {

        List<Antwoord> antwoorden = antwoordService.leesAntwoordenVanCourse(id);

        List<AntwoordResponseDTO> response = antwoorden.stream()
                .map(AntwoordResponseDTO::new)
                .toList();

        return ResponseEntity.ok(response);
    }
}
