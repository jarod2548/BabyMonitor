package org.babymonitor.Hartslag.Service;

import org.babymonitor.Hartslag.Model.Hartslag;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class HartslagService {

    private final List<Hartslag> metingen = new ArrayList<>();
    private final Random random = new Random();
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    private final int beginHartslag = 140;
    private int huidigeHartslag = 140;
    private final int variabiliteit = 20;

    public List<Hartslag> haalAlleMetingen() {
        return new ArrayList<>(metingen);
    }

    private int berekenVerandering(int huidige, int minBpm, int maxBpm, int[] stappen) {

        double positie = (huidige - minBpm) / (double) (maxBpm - minBpm);

        double kansOmhoog = 0.85 - 0.70 * positie;

        boolean omhoog = random.nextDouble() < kansOmhoog;

        int grootte = stappen[random.nextInt(stappen.length)];

        if (omhoog) {
            return Math.abs(grootte);
        } else {
            return -Math.abs(grootte);
        }
    }

    @Scheduled(fixedRate = 1000)
    public void maakNieuweHartslag() {

        int[] stappen = {2, 4, 6};

        int minBpm = beginHartslag - variabiliteit;
        int maxBpm = beginHartslag + variabiliteit;

        int verandering = berekenVerandering(huidigeHartslag, minBpm, maxBpm, stappen);

        int nieuweHartslag = huidigeHartslag + verandering;

        if (nieuweHartslag < minBpm) {
            nieuweHartslag = minBpm;
        }

        if (nieuweHartslag > maxBpm) {
            nieuweHartslag = maxBpm;
        }

        huidigeHartslag = nieuweHartslag;

        String tijd = LocalTime.now().format(formatter);

        metingen.add(new Hartslag(huidigeHartslag, tijd));
    }
}