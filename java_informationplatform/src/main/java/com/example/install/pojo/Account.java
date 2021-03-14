package com.example.install.pojo;

import org.springframework.lang.Nullable;

import java.io.Serializable;
import java.math.BigDecimal;

public class Account implements Serializable {
    private int id;
    private String contractName;
    private double amountSum; //付款金额
    private double amountActual;//实际付款金额
    private double proceedsSum; //收入总金额
    private double proceedsActual;//实际收入总金额
    private int elevatorCount;//总台数
    private String signDate; //合同日期
    private String City; //城市
    private String Supplier;//开发商
    private String contractCompany;//厂商
    private String note;
    private double ratio;  //比例




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public double getAmountSum() {
        return amountSum;
    }

    public void setAmountSum(double amountSum) {
        this.amountSum = amountSum;
    }

    public double getAmountActual() {
        return amountActual;
    }

    public void setAmountActual(double amountActual) {
        this.amountActual = amountActual;
    }

    public double getProceedsSum() {
        return proceedsSum;
    }

    public void setProceedsSum(double proceedsSum) {
        this.proceedsSum = proceedsSum;
    }

    public double getProceedsActual() {
        return proceedsActual;
    }

    public void setProceedsActual(double proceedsActual) {
        this.proceedsActual = proceedsActual;
    }

    public int getElevatorCount() {
        return elevatorCount;
    }

    public void setElevatorCount(int elevatorCount) {
        this.elevatorCount = elevatorCount;
    }

    public String getSignDate() {
        return signDate;
    }

    public void setSignDate(String signDate) {
        this.signDate = signDate;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getSupplier() {
        return Supplier;
    }

    public void setSupplier(String supplier) {
        Supplier = supplier;
    }

    public String getContractCompany() {
        return contractCompany;
    }

    public void setContractCompany(String contractCompany) {
        this.contractCompany = contractCompany;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }
}
