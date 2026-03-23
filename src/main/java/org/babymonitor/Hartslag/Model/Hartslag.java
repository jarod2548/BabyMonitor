package org.babymonitor.Hartslag.Model;

public class Hartslag{

    private int bpm;
    private String tijd;

    public Hartslag(int Bpm, String Tijd) {
        bpm = Bpm;
        tijd = Tijd;
    }

    public int getBpm() {
        return bpm;
    }

    public String getTijd() {
        return tijd;
    }

}