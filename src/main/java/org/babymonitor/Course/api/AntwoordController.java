package org.babymonitor.Course.api;

import jakarta.validation.Valid;
import java.util.List;
import org.babymonitor.Course.model.antwoord.Antwoord;
import org.babymonitor.Course.model.antwoord.AntwoordDTO;
import org.babymonitor.Course.model.antwoord.AntwoordResponseDTO;
import org.babymonitor.Course.service.AntwoordService;
import org.babymonitor.Security.UserPrincipal;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AntwoordController {

  private final AntwoordService antwoordService;

  public AntwoordController(AntwoordService antwoordService) {
    this.antwoordService = antwoordService;
  }

  @PostMapping("/teacher/antwoord")
  public ResponseEntity<AntwoordResponseDTO> maakAntwoord(
      @RequestBody @Valid AntwoordDTO dto, @AuthenticationPrincipal UserPrincipal user) {

    Antwoord saved = antwoordService.maakAntwoord(dto.naarModel(), dto.getCourseID());

    return ResponseEntity.ok(new AntwoordResponseDTO(saved));
  }

  @GetMapping("/user/antwoord/{id}")
  public ResponseEntity<List<AntwoordResponseDTO>> leesAntwoorden(@PathVariable Long id) {

    List<Antwoord> antwoorden = antwoordService.leesAntwoordenVanCourse(id);

    List<AntwoordResponseDTO> response = antwoorden.stream().map(AntwoordResponseDTO::new).toList();

    return ResponseEntity.ok(response);
  }
}
