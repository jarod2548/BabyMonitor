package org.babymonitor.connection.api;

import org.babymonitor.CTG.hartslag.HartslagDoelDTO;
import org.babymonitor.CTG.wee.WeeDoelDTO;
import org.babymonitor.connection.service.ConnectionService;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
public class ConnectionController {

    private final ConnectionService connectionService;

    public ConnectionController(ConnectionService connectionService) {
        this.connectionService = connectionService;
    }

    @MessageMapping("/group/{id}/hartslag")
    public void updateBaseline(
            @DestinationVariable String id,
            HartslagDoelDTO hartslagDoelDTO) {
            connectionService.updateHartslag(id, hartslagDoelDTO);
    }

    @MessageMapping("/group/{id}/contraction")
    public void triggerContraction(
            @DestinationVariable String id,
            WeeDoelDTO weeDoelDTO) {
        connectionService.updateWee(id, weeDoelDTO);
    }
}
