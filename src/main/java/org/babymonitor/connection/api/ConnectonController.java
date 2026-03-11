package org.babymonitor.connection.api;

import org.babymonitor.connection.service.ConnectionService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;


@Controller
public class ConnectonController {
    private final ConnectionService connectionService;
    private final SimpMessagingTemplate simpMessagingTemplate;

    public ConnectonController(ConnectionService CS, SimpMessagingTemplate SMT){
        this.connectionService = CS;
        simpMessagingTemplate = SMT;
    }

    @MessageMapping("/create")
    public void createGroup(String sessionId) {

        String groupId = connectionService.maakGroepSessie(sessionId);
        System.out.println("group created fired");

        simpMessagingTemplate.convertAndSend("/topic/group-created", groupId);
    }
}
