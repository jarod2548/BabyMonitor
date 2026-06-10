package org.babymonitor.CTGSimulator.model;

public class CtgPoint {
    private int x;
    private Long timestamp;
    private int fhrBpm;
    private int wee;

    public CtgPoint(int X, Long Timestamp, int FhrBpm, int Wee)
    {
        this.x = X;
        this.timestamp = Timestamp;
        this.fhrBpm = FhrBpm;
        this.wee = Wee;
    }


    public int getFhrBpm() {
        return fhrBpm;
    }

    public int getWee() {
        return wee;
    }

    public int getX() {
        return x;
    }

    public Long getTimestamp() {
        return timestamp;
    }
}
