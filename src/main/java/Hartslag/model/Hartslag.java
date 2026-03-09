package Hartslag.model;

import java.util.Random;

public class Hartslag {

    private int iBpm;// initial bpm
    private int cBpm;// current bpm
    private int variabiliteit;

    public Hartslag(int initialbpm, int variabiliteit) {
        this.iBpm = initialbpm;
        this.cBpm = initialbpm;
        this.variabiliteit = variabiliteit;
    }

    public int getHartslag() {
        return cBpm;
    }

    public int getVariabiliteit() {
        return variabiliteit;
    }

    public void setHartslag(int hartslag) {
        this.cBpm = hartslag;
    }

    // Random biased change: more likely to go up when near min, more likely to go,
    // down when near max
    private int biasedChange(int current, int min, int max, int[] steps, Random random) {

        double t = (current - min) / (double) (max - min);

        // Probability to go UP:
        // near min (t≈0) => ~0.85
        // near max (t≈1) => ~0.15
        double pUp = 0.85 - 0.70 * t;

        boolean goUp = random.nextDouble() < pUp;

        // choose magnitude (2/4/6) and sign it
        int magnitude = steps[random.nextInt(steps.length)];
        if (magnitude == 0)
            return 0;

        return goUp ? Math.abs(magnitude) : -Math.abs(magnitude);
    }

    public void heartbeat() {
        // create a Hartslag object

        Random random = new Random();

        int[] magnitudes = { 2, 4, 6, };// keep within range

        int minBpm = this.iBpm - this.getVariabiliteit();
        int maxBpm = this.iBpm + this.getVariabiliteit();

        int current = this.getHartslag();

        int change = biasedChange(current, minBpm, maxBpm, magnitudes, random);

        int newBpm = current + change;

        if (newBpm < minBpm)
            newBpm = minBpm;
        if (newBpm > maxBpm)
            newBpm = maxBpm;

        this.setHartslag(newBpm);

        System.out.println("Heart Rate: " + this.getHartslag() + " BPM");
    }

}
