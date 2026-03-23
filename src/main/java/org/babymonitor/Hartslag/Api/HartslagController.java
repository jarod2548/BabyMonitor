package org.babymonitor.Hartslag.Api;

import org.babymonitor.Hartslag.Model.Hartslag;
import org.babymonitor.Hartslag.Service.HartslagService;
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
    public List<Hartslag> haalHartslagOp() {
        return service.haalAlleMetingen();
    }
}