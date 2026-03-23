package org.babymonitor.model;

public class Hartslag{

    private int bpm;
    private String tijd;
    private String status;

    public Hartslag(int Bpm, String Tijd, String Status) {
        bpm = Bpm;
        tijd = Tijd;
        status = Status;
    }

    public int getBpm() {
        return bpm;
    }

    public String getTijd() {
        return tijd;
    }

    public String getStatus() {
        return status;
    }
}