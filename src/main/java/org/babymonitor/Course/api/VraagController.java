package org.babymonitor.Course.api;

import jakarta.validation.Valid;
import org.babymonitor.Course.model.Vraag;
import org.babymonitor.Course.model.VraagDTO;
import org.babymonitor.Course.model.VraagResponseDTO;
import org.babymonitor.Course.service.VraagService;
import org.babymonitor.Security.UserPrincipal;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class VraagController {
    private final VraagService vraagService;

    public VraagController(VraagService vraagService) {
        this.vraagService = vraagService;
    }

    @PostMapping("/teacher/vraag")
    public ResponseEntity<VraagResponseDTO> maakVraag(@RequestBody
                          @Valid
                          VraagDTO dto,
                                                      @AuthenticationPrincipal UserPrincipal user){
        Vraag saved = vraagService.maakVraag(dto.naarModel(), dto.getCourseID());

        return ResponseEntity.ok(new VraagResponseDTO(saved));
    }
}
