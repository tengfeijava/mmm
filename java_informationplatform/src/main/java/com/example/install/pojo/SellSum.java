package com.example.install.pojo;

import java.math.BigDecimal;

public class SellSum {
    private int sellsum;  //销售总台数
    private BigDecimal sellexpend; //销售支出总额  付款
    private BigDecimal sellincome; //销售收入总额  回款


    public int getSellsum() {
        return sellsum;
    }

    public void setSellsum(int sellsum) {
        this.sellsum = sellsum;
    }

    public BigDecimal getSellincome() {
        return sellincome;
    }

    public void setSellincome(BigDecimal sellincome) {
        this.sellincome = sellincome;
    }

    public BigDecimal getSellexpend() {
        return sellexpend;
    }

    public void setSellexpend(BigDecimal sellexpend) {
        this.sellexpend = sellexpend;
    }
}
