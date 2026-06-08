package org.babymonitor.connection.api;

import java.util.List;

import org.babymonitor.Security.UserPrincipal;
import org.babymonitor.connection.model.Groep;
import org.babymonitor.connection.service.ConnectionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController

public class GroepController {

  private final ConnectionService connectionService;

  public GroepController(ConnectionService connectionService) {

      this.connectionService = connectionService;
  }

  @GetMapping("/user/groep")
  public List<Groep> getAlleGroepen() {
    return connectionService.getAlleGroepen();
  }

  @PostMapping("teacher/groep")
  public ResponseEntity<MaakGroepResponse> maakGroep(@RequestBody MaakGroepRequest request) {
    Groep model = connectionService.maakGroep(request.getNaam());
    return ResponseEntity.status(HttpStatus.CREATED)
            .body(new MaakGroepResponse(model));
  }
}
