package Hartslag.model;

import java.util.Random;

public class Uterus {

    private int iActiviteit;
    private int cActiviteit;
    private String Wee_type;
    private int Wee_duur; // duration in ticks
    private int Wee_frequentie; // start a contraction every N ticks (simple model)
    private int Wee_intensiteit; // intensity (used for peak height)

    // contraction state
    private boolean contracting = false;
    private int tickInContraction = 0;
    private int totalTicks = 0;
    private int peak = 0;

    // scheduling state
    private int globalTick = 0;

    private final Random random = new Random();

    public Uterus(String wee_type, int wee_duur, int wee_frequentie, int wee_intensiteit) {
        this.iActiviteit = 20;
        this.cActiviteit = 20;
        this.Wee_type = wee_type;
        this.Wee_duur = wee_duur;
        this.Wee_frequentie = wee_frequentie;
        this.Wee_intensiteit = wee_intensiteit;
    }

    public void setWee_type(String wee_type) {
        this.Wee_type = wee_type;
    }

    public void setWee_duur(int wee_duur) {
        this.Wee_duur = wee_duur;
    }

    public void setWee_frequentie(int wee_frequentie) {
        this.Wee_frequentie = wee_frequentie;
    }

    public void setWee_intensiteit(int wee_intensiteit) {
        this.Wee_intensiteit = wee_intensiteit;
    }

    public void setUterusactiviteit(int uterusactiviteit) {
        this.cActiviteit = uterusactiviteit;
    }

    public int getUterusactiviteit() {
        return cActiviteit;
    }

    private int biasedChange(int current, int min, int max, int[] steps, Random random) {
        double t = (current - min) / (double) (max - min);
        double pUp = 0.85 - 0.70 * t;
        boolean goUp = random.nextDouble() < pUp;

        int magnitude = steps[random.nextInt(steps.length)];
        if (magnitude == 0)
            return 0;

        return goUp ? Math.abs(magnitude) : -Math.abs(magnitude);
    }

    public void toco() {
        int[] magnitudes = { 0, 1, 2 };

        int minActivity = iActiviteit - 3;
        int maxActivity = iActiviteit + 3;

        int current = this.getUterusactiviteit();
        int change = biasedChange(current, minActivity, maxActivity, magnitudes, random);

        int newActivity = current + change;
        if (newActivity < minActivity)
            newActivity = minActivity;
        if (newActivity > maxActivity)
            newActivity = maxActivity;

        this.setUterusactiviteit(newActivity);
        System.out.println("Uterus Activity (toco): " + this.getUterusactiviteit());
    }

    public void startContraction() {
        contracting = true;
        tickInContraction = 0;
        totalTicks = Math.max(2, Wee_duur);

        // Map intensity -> peak.
        // If Wee_intensiteit is 0..100, this makes peak roughly:
        // intensity 60 => +20 => 40 (baseline 20)
        int extra = (int) Math.round((Wee_intensiteit / 100.0) * 34.0); // 0..34
        peak = iActiviteit + extra;

        // small randomness so it's not identical every time
        peak += random.nextInt(3) - 1;

        if (peak < iActiviteit)
            peak = iActiviteit;
    }

    private void contractionTick() {
        int half = totalTicks / 2;
        int upTicks = Math.max(1, half);
        int downTicks = Math.max(1, totalTicks - upTicks);

        int newValue;
        if (tickInContraction <= upTicks) {
            double p = tickInContraction / (double) upTicks; // 0..1
            newValue = (int) Math.round(iActiviteit + p * (peak - iActiviteit));
        } else {
            double p = (tickInContraction - upTicks) / (double) downTicks; // 0..1
            newValue = (int) Math.round(peak - p * (peak - iActiviteit));
        }

        cActiviteit = newValue;
        System.out.println("Uterus Activity (contraction): " + cActiviteit);

        tickInContraction++;
        if (tickInContraction > totalTicks) {
            cActiviteit = iActiviteit;
            contracting = false;
        }
    }

    public void update() {
        globalTick++;

        // very simple scheduling: every N ticks start contraction
        if (!contracting && Wee_frequentie > 0 && globalTick % Wee_frequentie == 0) {
            startContraction();
        }

        if (contracting) {
            contractionTick();
        } else {
            toco();
        }
    }
}
