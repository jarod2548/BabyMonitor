package org.babymonitor.connection.service;

import org.babymonitor.CTGSimulator.CtgGeneratorService;
import org.babymonitor.CTGSimulator.model.CtgPoint;
import org.babymonitor.connection.model.Groep;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class BroadcastService {
    private final ConnectionService connectionService;
    private final CtgGeneratorService generator;
    private final SimpMessagingTemplate messagingTemplate;

    public  BroadcastService(
            ConnectionService connectionService,
            CtgGeneratorService generator,
            SimpMessagingTemplate messagingTemplate) {
        this.connectionService = connectionService;

        this.generator = generator;
        this.messagingTemplate = messagingTemplate;
    }

    @Scheduled(fixedRate = 1000)
    public void broadcast() {

        for (Groep groep : connectionService.getAlleGroepen()) {

            CtgPoint point = generator.generate(groep);
            messagingTemplate.convertAndSend(
                    "/topic/group/" + groep.getId() + "/ctg",
                    point
            );
        }
    }
}
