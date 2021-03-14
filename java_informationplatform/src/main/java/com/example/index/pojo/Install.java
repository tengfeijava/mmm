package com.example.index.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;



public class Install implements Serializable {
    private int installsum;        //总台数
    private BigDecimal installexpend; //总额  付款
    private BigDecimal installincome; //已收入总额  回款

    public int getInstallsum() {
        return installsum;
    }

    public void setInstallsum(int installsum) {
        this.installsum = installsum;
    }

    public BigDecimal getInstallincome() {
        return installincome;
    }

    public void setInstallincome(BigDecimal installincome) {
        this.installincome = installincome;
    }

    public BigDecimal getInstallexpend() {
        return installexpend;
    }

    public void setInstallexpend(BigDecimal installexpend) {
        this.installexpend = installexpend;
    }
}
