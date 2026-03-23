package org.babymonitor.Groep.api;

import org.babymonitor.Groep.model.Groep;
import org.babymonitor.Groep.service.GroepService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groepen")
public class GroepController {

    private final GroepService groepService;

    public GroepController(GroepService groepService) {
        this.groepService = groepService;
    }

    @GetMapping
    public List<Groep> getAlleGroepen() {
        return groepService.getAlleGroepen();
    }

    @PostMapping
    public Groep maakGroep(@RequestBody MaakGroepRequest request) {
        return groepService.maakGroep(request.naam());
    }

    public record MaakGroepRequest(String naam) {
    }
}
//push test