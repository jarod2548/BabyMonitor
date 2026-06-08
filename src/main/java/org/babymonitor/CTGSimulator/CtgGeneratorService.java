package org.babymonitor.CTGSimulator;

import org.babymonitor.CTGSimulator.model.CtgPoint;
import org.babymonitor.CTGdata;
import org.babymonitor.connection.model.Groep;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class CtgGeneratorService {
    public CtgPoint generate(Groep groep) {

        CTGdata ctg = groep.getCtgdata();

        groep.setTijd(groep.getTijd() + 1);

        int baseline = ctg.getHartbasis();
        int variability = ctg.getVariabiliteit();

        int heartRate =
                baseline + ThreadLocalRandom.current()
                        .nextInt(-variability, variability + 1);

        return new CtgPoint(
                0,
                groep.getTijd(),
                heartRate,
                0
        );
    }
}
