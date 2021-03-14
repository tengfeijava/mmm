package com.example.cooperation.pojo;



import java.io.Serializable;



public class Particulars implements Serializable {
    private int id;
    private String serviceName;
    private int serviceNumber;  //台数
    private String serviceType;  //合同类型
    private String servicePeriod;//付款周期

    private String serviceCity;  //城市
    private String serviceFirm;  //厂商
    private String serviceObject;//物业
    private double servicePaymen;     //支出总额
    private double serviceGathering; //收款总额
    private String serviceJlinkman;
    private String serviceJposition;
    private String serviceJphone;
    private String serviceYlinkman;
    private String serviceYposition;
    private String serviceYphone;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
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



    public String getServiceCity() {
        return serviceCity;
    }

    public void setServiceCity(String serviceCity) {
        this.serviceCity = serviceCity;
    }

    public String getServiceFirm() {
        return serviceFirm;
    }

    public void setServiceFirm(String serviceFirm) {
        this.serviceFirm = serviceFirm;
    }

    public String getServiceObject() {
        return serviceObject;
    }

    public void setServiceObject(String serviceObject) {
        this.serviceObject = serviceObject;
    }

    public double getServicePaymen() {
        return servicePaymen;
    }

    public void setServicePaymen(double servicePaymen) {
        this.servicePaymen = servicePaymen;
    }

    public double getServiceGathering() {
        return serviceGathering;
    }

    public void setServiceGathering(double serviceGathering) {
        this.serviceGathering = serviceGathering;
    }

    public String getServiceJlinkman() {
        return serviceJlinkman;
    }

    public void setServiceJlinkman(String serviceJlinkman) {
        this.serviceJlinkman = serviceJlinkman;
    }

    public String getServiceJposition() {
        return serviceJposition;
    }

    public void setServiceJposition(String serviceJposition) {
        this.serviceJposition = serviceJposition;
    }

    public String getServiceJphone() {
        return serviceJphone;
    }

    public void setServiceJphone(String serviceJphone) {
        this.serviceJphone = serviceJphone;
    }

    public String getServiceYlinkman() {
        return serviceYlinkman;
    }

    public void setServiceYlinkman(String serviceYlinkman) {
        this.serviceYlinkman = serviceYlinkman;
    }

    public String getServiceYposition() {
        return serviceYposition;
    }

    public void setServiceYposition(String serviceYposition) {
        this.serviceYposition = serviceYposition;
    }

    public String getServiceYphone() {
        return serviceYphone;
    }

    public void setServiceYphone(String serviceYphone) {
        this.serviceYphone = serviceYphone;
    }
}
