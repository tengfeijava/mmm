package com.example.install.pojo;

import java.math.BigDecimal;

public class InstallSum {

    private int installSum;     //安装总台数
    private BigDecimal installExpend; //安装支出总额  付款
    private BigDecimal installIncome; //安装收入总额  回款

    public int getInstallSum() {
        return installSum;
    }

    public void setInstallSum(int installSum) {
        this.installSum = installSum;
    }

    public BigDecimal getInstallExpend() {
        return installExpend;
    }

    public void setInstallExpend(BigDecimal installExpend) {
        this.installExpend = installExpend;
    }

    public BigDecimal getInstallIncome() {
        return installIncome;
    }

    public void setInstallIncome(BigDecimal installIncome) {
        this.installIncome = installIncome;
    }
}
