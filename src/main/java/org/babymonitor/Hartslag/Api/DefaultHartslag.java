package org.babymonitor.Hartslag.Api;

public class DefaultHartslag{

    private int bpm;
    private String tijd;
    private String status;

    public DefaultHartslag(int Bpm, String Tijd, String Status) {
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