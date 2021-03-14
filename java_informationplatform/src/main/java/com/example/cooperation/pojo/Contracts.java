package com.example.cooperation.pojo;

import javax.validation.constraints.Null;
import java.io.Serializable;
import java.util.List;

public class Contracts implements Serializable {
    private int id;
    private String contractName;

    private String startTime;
    private String endTime;
    private int serviceNumber;  //总台数
    private double gatheringSum; //收入总金额
    private double paymentSum; //支出总金额
    private String serviceType;  //合同类型
    private String servicePeriod;//付款周期
    private String city; //城市
    private String firm; //厂商
    private String serviceobject;//物业
    private String serviceStartEnd;//账期





    private Particulars particulars;
    private List<GatheringPayment> paymentList;//payment 付款 gathering 收款
    private List<GatheringPayment> gatheringList;//payment 付款 gathering 收款




    public double getGatheringSum() {
        return gatheringSum;
    }

    public void setGatheringSum(double gatheringSum) {
        this.gatheringSum = gatheringSum;
    }

    public double getPaymentSum() {
        return paymentSum;
    }

    public void setPaymentSum(double paymentSum) {
        this.paymentSum = paymentSum;
    }

    public String getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    public String getServiceobject() {
        return serviceobject;
    }

    public void setServiceobject(String serviceobject) {
        this.serviceobject = serviceobject;
    }

    public String getServiceStartEnd() {
        return serviceStartEnd;
    }

    public void setServiceStartEnd(String serviceStartEnd) {
        this.serviceStartEnd = serviceStartEnd;
    }




    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }



    public Particulars getParticulars() {
        return particulars;
    }

    public void setParticulars(Particulars particulars) {
        this.particulars = particulars;
    }

    public List<GatheringPayment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<GatheringPayment> paymentList) {
        this.paymentList = paymentList;
    }

    public List<GatheringPayment> getGatheringList() {
        return gatheringList;
    }

    public void setGatheringList(List<GatheringPayment> gatheringList) {
        this.gatheringList = gatheringList;
    }

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



    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getServiceNumber() {
        return serviceNumber;
    }

    public void setServiceNumber(int serviceNumber) {
        this.serviceNumber = serviceNumber;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getServicePeriod() {
        return servicePeriod;
    }

    public void setServicePeriod(String servicePeriod) {
        this.servicePeriod = servicePeriod;
    }
}
