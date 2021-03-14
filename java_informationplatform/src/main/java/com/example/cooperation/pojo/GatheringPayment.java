package com.example.cooperation.pojo;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

//维保收款 付款
public class GatheringPayment extends Particulars implements Serializable  {
    private int id;
    private String serviceName;  //账期名称
    private String serviceStartEnd;  //账期
    private String serviceTime;  //回款时间
    private double serviceMoney; //金额
    private String serviceExpire; //到期时间
    private String servicePeriod;  //周期金额
    private String serviceAccessory;//附件
    private String serviceClass;  //payment 付款 gathering 收款
    private MultipartFile fileImg;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MultipartFile getFileImg() {
        return fileImg;
    }

    public void setFileImg(MultipartFile fileImg) {
        this.fileImg = fileImg;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceStartEnd() {
        return serviceStartEnd;
    }

    public void setServiceStartEnd(String serviceStartEnd) {
        this.serviceStartEnd = serviceStartEnd;
    }

    public String getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(String serviceTime) {
        this.serviceTime = serviceTime;
    }

    public double getServiceMoney() {
        return serviceMoney;
    }

    public void setServiceMoney(double serviceMoney) {
        this.serviceMoney = serviceMoney;
    }

    public String getServiceExpire() {
        return serviceExpire;
    }

    public void setServiceExpire(String serviceExpire) {
        this.serviceExpire = serviceExpire;
    }

    public String getServicePeriod() {
        return servicePeriod;
    }

    public void setServicePeriod(String servicePeriod) {
        this.servicePeriod = servicePeriod;
    }

    public String getServiceAccessory() {
        return serviceAccessory;
    }

    public void setServiceAccessory(String serviceAccessory) {
        this.serviceAccessory = serviceAccessory;
    }

    public String getServiceClass() {
        return serviceClass;
    }

    public void setServiceClass(String serviceClass) {
        this.serviceClass = serviceClass;
    }
}
