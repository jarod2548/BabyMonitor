package org.babymonitor.CTGSimulator.model;

import java.time.LocalDateTime;

public class CtgPoint {
    private int x;
    private Long timestamp;
    private int fhrBpm;
    private int toco;

    public CtgPoint(int X, Long Timestamp, int FhrBpm, int Toco)
    {
        x = X;
        timestamp = Timestamp;
        fhrBpm = FhrBpm;
        toco= Toco;
    }


    public int getFhrBpm() {
        return fhrBpm;
    }

    public int getToco() {
        return toco;
    }

    public int getX() {
        return x;
    }

    public Long getTimestamp() {
        return timestamp;
    }
}
