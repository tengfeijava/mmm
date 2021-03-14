package com.example.install.pojo;

public class Details {
    private int idh;
    private String contract_name;  //名称
//    private String brand; //品牌
//    private String city;  //城市
//    private String supplier; //厂商
    private String type;  //梯号
    private int number; //电梯数
    private double price; //安装单价
    private double returnedmoney; //回款金额
    private int count;
    private double hratio;
    private String elevatorclass; //类型
    private double install_expend;
    private String deAccessory; //发票地址




    public String getDeAccessory() {
        return deAccessory;
    }

    public void setDeAccessory(String deAccessory) {
        this.deAccessory = deAccessory;
    }

    public String getElevatorclass() {
        return elevatorclass;
    }

    public void setElevatorclass(String elevatorclass) {
        this.elevatorclass = elevatorclass;
    }

    public double getInstall_expend() {
        return install_expend;
    }

    public void setInstall_expend(double install_expend) {
        this.install_expend = install_expend;
    }

    public double getHratio() {
        return hratio;
    }

    public void setHratio(double hratio) {
        this.hratio = hratio;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getIdh() {
        return idh;
    }

    public void setIdh(int idh) {
        this.idh = idh;
    }

    public String getContract_name() {
        return contract_name;
    }

    public void setContract_name(String contract_name) {
        this.contract_name = contract_name;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getReturnedmoney() {
        return returnedmoney;
    }

    public void setReturnedmoney(double returnedmoney) {
        this.returnedmoney = returnedmoney;
    }
}
