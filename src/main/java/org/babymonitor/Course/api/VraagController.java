package org.babymonitor.Course.api;

import jakarta.validation.Valid;
import org.babymonitor.Course.model.*;
import org.babymonitor.Course.service.VraagService;
import org.babymonitor.Security.UserPrincipal;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class VraagController {

    private final VraagService vraagService;

    public VraagController(VraagService vraagService) {
        this.vraagService = vraagService;
    }

    @PostMapping("/teacher/vraag")
    public ResponseEntity<VraagResponseDTO> maakVraag(
            @RequestBody
            @Valid
            VraagDTO dto,

            @AuthenticationPrincipal
            UserPrincipal user){

        Vraag saved = vraagService.maakVraag(dto.naarModel());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new VraagResponseDTO(saved));
    }

    @GetMapping("/user/vraag/{courseId}")
    public ResponseEntity<List<VraagResponseDTO>> leesVragen(
            @AuthenticationPrincipal UserPrincipal user,

            @PathVariable Long courseId){

        List<Vraag> resultaten =
                vraagService.leesVragen(courseId);

        List<VraagResponseDTO> response =
                new ArrayList<>();

        for(Vraag v : resultaten){
            response.add(new VraagResponseDTO(v));
        }

        return ResponseEntity.ok(response);
    }

    @PostMapping("/teacher/vraag-antwoord")
    public ResponseEntity<VraagAntwoordResponseDTO> maakVraagAntwoord(
            @RequestBody
            @Valid
            VraagAntwoordDTO dto
    ) {

        VraagAntwoord saved =
                vraagService.maakVraagAntwoord(
                        dto.getVraagId(),
                        dto.getAntwoordId(),
                        dto.isCorrect()
                );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new VraagAntwoordResponseDTO(saved));
    }

    @PostMapping("/antwoord/check")
    public ResponseEntity<Boolean> controleerAntwoord(
            @RequestBody
            @Valid
            ControleAntwoordDTO dto
    ){

        boolean correct =
                vraagService.controleerAntwoord(
                        dto.getVraagId(),
                        dto.getAntwoordId()
                );

        return ResponseEntity.ok(correct);
    }
}