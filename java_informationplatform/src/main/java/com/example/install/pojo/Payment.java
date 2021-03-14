package com.example.install.pojo;

public class Payment {
    private int idf;
    private String fcontractname; //名称
//    private String fcity; //城市
//    private String fbrand;//品牌
    private String ftype; //梯号
    private int fnumber; //电梯数量
    private double fprice; //付款单价
    private double fpayment; //付款金额
    private int fcount;
    private double fratio;
    private String felevatorclass;
    private double finstallexpend;
    private String fAccessory; //发票地址


    public int getIdf() {
        return idf;
    }

    public void setIdf(int idf) {
        this.idf = idf;
    }

    public String getFcontractname() {
        return fcontractname;
    }

    public void setFcontractname(String fcontractname) {
        this.fcontractname = fcontractname;
    }



    public String getFtype() {
        return ftype;
    }

    public void setFtype(String ftype) {
        this.ftype = ftype;
    }



    public int getFnumber() {
        return fnumber;
    }

    public void setFnumber(int fnumber) {
        this.fnumber = fnumber;
    }

    public double getFprice() {
        return fprice;
    }

    public void setFprice(double fprice) {
        this.fprice = fprice;
    }

    public double getFpayment() {
        return fpayment;
    }

    public void setFpayment(double fpayment) {
        this.fpayment = fpayment;
    }

    public int getFcount() {
        return fcount;
    }

    public void setFcount(int fcount) {
        this.fcount = fcount;
    }

    public double getFratio() {
        return fratio;
    }

    public void setFratio(double fratio) {
        this.fratio = fratio;
    }

    public String getFelevatorclass() {
        return felevatorclass;
    }

    public void setFelevatorclass(String felevatorclass) {
        this.felevatorclass = felevatorclass;
    }

    public double getFinstallexpend() {
        return finstallexpend;
    }

    public void setFinstallexpend(double finstallexpend) {
        this.finstallexpend = finstallexpend;
    }

    public String getfAccessory() {
        return fAccessory;
    }

    public void setfAccessory(String fAccessory) {
        this.fAccessory = fAccessory;
    }
}
