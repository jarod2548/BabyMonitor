package org.babymonitor.CTG.wee;

import org.babymonitor.CTG.AcceleratieType;

public class WeeStatus {
    private int duur;
    private int sterkte;
    private AcceleratieType type;

    public WeeStatus(int duur, int sterkte, AcceleratieType type){
        this.duur = duur;
        this.sterkte = sterkte;
        this.type = type;
    }

    public AcceleratieType getType() {
        return type;
    }

    public int getDuur() {
        return duur;
    }

    public int getSterkte() {
        return sterkte;
    }

    public void setValues(WeeDoelDTO dto){
        sterkte = dto.getWeeSterkte();
        duur = dto.getWeeDuratie();
        type = dto.getAcceleratieType();
    }
}
