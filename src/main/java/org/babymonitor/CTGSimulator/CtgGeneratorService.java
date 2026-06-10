package org.babymonitor.CTGSimulator;

import org.babymonitor.CTG.wee.WeeStatus;
import org.babymonitor.CTGSimulator.model.CtgPoint;
import org.babymonitor.CTG.ctg.CTGdata;
import org.babymonitor.connection.model.Groep;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class CtgGeneratorService {
    public CtgPoint generate(Groep groep) {

        CTGdata ctg = groep.getCtgdata();

        groep.tick();

        berekenHartslag(groep);

        int baseline = ctg.getHartbasis();
        int variability = ctg.getVariabiliteit();

        int heartRate =
                baseline + ThreadLocalRandom.current()
                        .nextInt(-variability, variability + 1);

        long tijd = groep.getTijd();

        WeeStatus weeStatus = groep.getWeeStatus();

        int wee = berekenWee(tijd, weeStatus);

        return new CtgPoint(
                0,
                groep.getTijd(),
                heartRate,
                wee
        );
    }

    private void berekenHartslag(Groep groep){
        if (groep.getTijdOver() > 0) {

            CTGdata ctg = groep.getCtgdata();
            int current = groep.getCtgdata().getHartbasis();
            int target = groep.getHartslagDoel();
            double baseline = (target - current)
                    / (double) groep.getTijdOver();

            double newBaseline = ctg.getHartbasis() + baseline;

            ctg.setHartbasis((int)Math.round(newBaseline));
            groep.tickHartslagTransactie();
        }
    }

    private int berekenWee(long tijd, WeeStatus weeStatus) {

        int weeDuratie = weeStatus.getDuur();
        int weeSterkte = weeStatus.getSterkte();

        if (weeDuratie <= 0) {
            return 0;
        }

        int cycleLength = 180;
        int positionInCycle = (int) (tijd % cycleLength);

        if (positionInCycle >= weeDuratie) {
            return 0;
        }

        double phase =
                Math.PI * positionInCycle / weeDuratie;

        return (int) (
                weeSterkte * Math.sin(phase)
        );
    }
}
