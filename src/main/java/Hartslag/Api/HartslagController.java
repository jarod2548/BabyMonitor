package org.babymonitor.api;

import org.babymonitor.model.DefaultHartslag;
import org.babymonitor.service.HartslagService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/baby-hartslag")
@CrossOrigin
public class HartslagController {

    private final HartslagService service;

    public HartslagController(HartslagService service) {
        this.service = service;
    }

    @GetMapping
    public List<DefaultHartslag> haalHartslagOp() {
        return service.haalAlleMetingen();
    }
}
