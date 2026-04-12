package org.babymonitor.Groep.api;

import org.babymonitor.Groep.model.Groep;
import org.babymonitor.Groep.service.GroepService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/user/groep")
public class GroepController {

    private final GroepService groepService;

    public GroepController(GroepService groepService) {
        this.groepService = groepService;
    }

    @GetMapping("/user/groep")
    public List<Groep> getAlleGroepen() {
        return groepService.getAlleGroepen();
    }

    @PostMapping("/groep")
    public Groep maakGroep(@RequestBody MaakGroepRequest request) {
        return groepService.maakGroep(request.getNaam());
    }

    @PostMapping("/join")
    public JoinGroepResponse joinGroep(@RequestBody JoinGroepRequest request) {
        Groep groep = groepService.joinGroep(request.getGroepId());

        return new JoinGroepResponse(
                "Groep succesvol gejoint",
                groep.getId(),
                groep.getNaam()
        );
    }

}