package org.babymonitor.Hartslag.Service;

import org.babymonitor.Hartslag.Api.DefaultHartslag;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class HartslagService {

    private final List<DefaultHartslag> metingen = new ArrayList<>();
    private final Random random = new Random();
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    public List<DefaultHartslag> haalAlleMetingen() {
        return metingen;
    }

    @Scheduled(fixedRate = 1000)
    public void maakNieuweAutomatischeHartslag() {

        int bpm = 90 + random.nextInt(90); // 90 - 180 bpm

        String tijd = LocalTime.now().format(formatter);

        String status;

        if (bpm < 110) {
            status = "LAAG";
        } else if (bpm > 160) {
            status = "HOOG";
        } else {
            status = "NORMAAL";
        }

        metingen.add(new DefaultHartslag(bpm, tijd, status));

        // if (metingen.size() > 20) {
        //   metingen.remove(0);
        //  }
    }
}