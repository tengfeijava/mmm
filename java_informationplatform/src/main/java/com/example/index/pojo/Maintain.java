package com.example.index.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

//维保
public class Maintain implements Serializable {

    private int maintainsum;
    private double maintainexpend;
    private double maintainincome;

    public int getMaintainsum() {
        return maintainsum;
    }

    public void setMaintainsum(int maintainsum) {
        this.maintainsum = maintainsum;
    }

    public double getMaintainincome() {
        return maintainincome;
    }

    public void setMaintainincome(double maintainincome) {
        this.maintainincome = maintainincome;
    }

    public double getMaintainexpend() {
        return maintainexpend;
    }

    public void setMaintainexpend(double maintainexpend) {
        this.maintainexpend = maintainexpend;
    }
}
