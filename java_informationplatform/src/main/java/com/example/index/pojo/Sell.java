package com.example.index.pojo;


import java.io.Serializable;
import java.math.BigDecimal;

//销售
public class Sell  implements Serializable {


    private int sellSum;     //销售总台数
    private BigDecimal sellExpend; //销售支出总额  付款
    private BigDecimal sellIncome; //销售收入总额  回款

    public int getSellSum() {
        return sellSum;
    }

    public void setSellSum(int sellSum) {
        this.sellSum = sellSum;
    }

    public BigDecimal getSellExpend() {
        return sellExpend;
    }

    public void setSellExpend(BigDecimal sellExpend) {
        this.sellExpend = sellExpend;
    }

    public BigDecimal getSellIncome() {
        return sellIncome;
    }

    public void setSellIncome(BigDecimal sellIncome) {
        this.sellIncome = sellIncome;
    }
}
