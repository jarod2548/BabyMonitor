package Hartslag.model;

import java.util.Random;

public class Uterus {

    private final int iActiviteit = 20; // baseline
    private int cActiviteit = 20;

    private String Wee_type;
    private int Wee_duur; // seconds
    private int Wee_frequentie; // x per 10 minutes
    private int Wee_intensiteit; // assume 0..100

    // time-based contraction state
    private boolean contracting = false;
    private long contractionStartMs = 0;
    private long contractionDurationMs = 0;
    private int peak = 0;

    // scheduling
    private long nextContractionAtMs = 0;

    private final Random random = new Random();

    public Uterus(String wee_type, int wee_duur, int wee_frequentie, int wee_intensiteit) {
        this.Wee_type = wee_type;
        this.Wee_duur = wee_duur;
        this.Wee_frequentie = wee_frequentie;
        this.Wee_intensiteit = wee_intensiteit;

        // schedule first contraction
        scheduleNextContraction(System.currentTimeMillis());
    }

    public int getUterusactiviteit() {
        return cActiviteit;
    }

    public boolean isContracting() {
        return contracting;
    }

    private int biasedChange(int current, int min, int max, int[] steps) {
        double t = (current - min) / (double) (max - min);
        double pUp = 0.85 - 0.70 * t;
        boolean goUp = random.nextDouble() < pUp;

        int magnitude = steps[random.nextInt(steps.length)];
        if (magnitude == 0)
            return 0;

        return goUp ? Math.abs(magnitude) : -Math.abs(magnitude);
    }

    /** Drift around baseline when idle. */
    private void tocoUpdate() {
        int[] magnitudes = { 0, 1, 2 };

        int minActivity = iActiviteit - 3;
        int maxActivity = iActiviteit + 3;

        int current = cActiviteit;
        int change = biasedChange(current, minActivity, maxActivity, magnitudes);

        int newActivity = current + change;
        if (newActivity < minActivity)
            newActivity = minActivity;
        if (newActivity > maxActivity)
            newActivity = maxActivity;

        cActiviteit = newActivity;
        System.out.println("Uterus Activity (toco): " + cActiviteit);
    }

    /**
     * Decide when the next contraction should start, using frequency x per 10
     * minutes.
     */
    private void scheduleNextContraction(long nowMs) {
        if (Wee_frequentie <= 0) {
            nextContractionAtMs = Long.MAX_VALUE; // never
            return;
        }

        // mean interval (ms) between contractions
        double meanIntervalSec = 600.0 / Wee_frequentie; // 600 sec = 10 minutes
        long meanIntervalMs = (long) (meanIntervalSec * 1000.0);

        // Add jitter so it's not perfectly periodic: ±20%
        double jitterFactor = 0.8 + (random.nextDouble() * 0.4); // 0.8 .. 1.2
        long intervalMs = Math.max(1000L, (long) (meanIntervalMs * jitterFactor));

        nextContractionAtMs = nowMs + intervalMs;
    }

    private void startContraction(long nowMs) {
        contracting = true;
        contractionStartMs = nowMs;
        contractionDurationMs = Math.max(1000L, Wee_duur * 1000L);

        // intensity mapping: 60 => about 40 (baseline 20)
        int intensityClamped = Math.max(0, Math.min(Wee_intensiteit, 100));
        int extra = (int) Math.round((intensityClamped / 100.0) * 34.0); // 0..34
        peak = iActiviteit + extra + (random.nextInt(3) - 1);
        if (peak < iActiviteit)
            peak = iActiviteit;
    }

    private void contractionUpdate(long nowMs) {
        long elapsed = nowMs - contractionStartMs;

        double p = elapsed / (double) contractionDurationMs; // 0..1
        if (p >= 1.0) {
            cActiviteit = iActiviteit;
            contracting = false;

            // schedule next contraction when one finishes
            scheduleNextContraction(nowMs);

            System.out.println("Uterus Activity (contraction done): " + cActiviteit);
            return;
        }

        // Smooth up-and-down: 0 -> 1 -> 0
        double shape = Math.sin(Math.PI * p);
        cActiviteit = (int) Math.round(iActiviteit + shape * (peak - iActiviteit));

        System.out.println("Uterus Activity (contraction): " + cActiviteit);
    }

    /**
     * Call frequently from a timer (e.g. every 100-500ms).
     * This method handles:
     * - when to start contractions (x per 10 min)
     * - contraction waveform
     * - fallback to TOCO drift when idle
     */
    public void update() {
        long nowMs = System.currentTimeMillis();

        if (!contracting && nowMs >= nextContractionAtMs) {
            startContraction(nowMs);
        }

        if (contracting)
            contractionUpdate(nowMs);
        else
            tocoUpdate();
    }
}
