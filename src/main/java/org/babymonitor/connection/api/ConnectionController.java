package org.babymonitor.connection.api;

import org.babymonitor.connection.model.CtgCommand;
import org.babymonitor.connection.service.ConnectionService;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller
public class ConnectionController {

    private final ConnectionService connectionService;

    public ConnectionController(ConnectionService connectionService) {
        this.connectionService = connectionService;
    }

    @MessageMapping("/group/{id}/hartslag")
    public void updateBaseline(
            @DestinationVariable String id,
            CtgCommand command) {
            connectionService.updateBaseline(id, command.getValue());
    }

    @MessageMapping("/group/{id}/variabiliteit")
    public void updateVariability(
            @DestinationVariable String id,
            CtgCommand command) {
        connectionService.updateVariability(id, command.getValue());
    }

    @MessageMapping("/group/{id}/contraction")
    public void triggerContraction(
            @DestinationVariable String id) {
        connectionService.triggerContraction(id);
    }
}
