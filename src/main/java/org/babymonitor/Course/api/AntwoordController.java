package org.babymonitor.Course.api;

import jakarta.validation.Valid;
import org.babymonitor.Course.model.Antwoord;
import org.babymonitor.Course.model.AntwoordDTO;
import org.babymonitor.Course.model.AntwoordResponseDTO;
import org.babymonitor.Course.service.AntwoordService;
import org.babymonitor.Security.UserPrincipal;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AntwoordController {

    private final AntwoordService antwoordService;

    public AntwoordController(AntwoordService antwoordService) {
        this.antwoordService = antwoordService;
    }

    public ResponseEntity<AntwoordResponseDTO> maakAntwoord(@RequestBody
                                                            @Valid
                                                            @AuthenticationPrincipal UserPrincipal user,
                                                            AntwoordDTO dto){
        Antwoord saved = antwoordService.maakAntwoord(dto.naarModel(), dto.naarModel().getId());
        return ResponseEntity.ok(new AntwoordResponseDTO(saved));
    }
}
