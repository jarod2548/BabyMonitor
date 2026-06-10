package org.babymonitor.Course.api;

import jakarta.validation.Valid;
import org.babymonitor.Course.model.antwoord.AntwoordMetStatus;
import org.babymonitor.Course.model.antwoord.ControleAntwoordDTO;
import org.babymonitor.Course.model.vraag.*;
import org.babymonitor.Course.service.VraagService;
import org.babymonitor.Security.UserPrincipal;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

        Vraag saved = vraagService.maakVraag(dto.naarModel(), dto.getCourseID());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new VraagResponseDTO(saved));
    }

    @GetMapping("/user/vraagCourse/{courseId}/{order}")
    public ResponseEntity<VraagResponseDTO> leesVraagCourse(
            @AuthenticationPrincipal UserPrincipal user,
            @PathVariable Long courseId,
            @PathVariable int order){

        Vraag resultaat = vraagService.leesVraag(courseId, order);

        return ResponseEntity.ok(new VraagResponseDTO(resultaat));
    }
    @GetMapping("/user/vraag/{vraagId}")
    public ResponseEntity<VraagResponseDTO> leesVraag(
            @AuthenticationPrincipal UserPrincipal user,
            @PathVariable Long vraagId){

        Vraag resultaat = vraagService.leesVraag(vraagId);

        return ResponseEntity.ok(new VraagResponseDTO(resultaat));
    }

    @GetMapping("/user/vragen/{courseId}")
    public ResponseEntity<List<VraagResponseDTO>> leesVragen(@PathVariable Long courseId){
        List<Vraag> resultaat = vraagService.leesVragen(courseId);
        return ResponseEntity.ok(resultaat.stream().map(VraagResponseDTO::new).toList());
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
                        dto.getAntwoordId()
                );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new VraagAntwoordResponseDTO(saved));
    }

    @GetMapping("/teacher/vraag-antwoord/{courseID}/{vraagID}")
    public ResponseEntity<List<AntwoordMetStatusDTO>> leesVraagAntwoorden(@RequestBody
                                                                              @Valid
                                                                              @PathVariable Long courseID,
                                                                              @PathVariable Long vraagID){
        List<AntwoordMetStatus> resultaten = vraagService.leesVraagAntwoorden(vraagID, courseID);
        return ResponseEntity.ok(resultaten.stream()
                .map(AntwoordMetStatusDTO::new)
                .toList());
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