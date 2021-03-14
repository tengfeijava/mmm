package com.example.install.pojo;

public class Invoice {
    private int id;
    private String invoice_type; //发票类型
    private int invoice_number; //发票号
    private String invoice_date; //发票时间
    private double invoice_money;//发票金额
    private String rate; //税率
    private String remarks; //备注
    private String accessory; //地址
    private String j_linkman; //甲方联系人
    private String j_position; //甲方职位
    private String j_phone; //甲方手机号
    private String y_linkman; //乙方
    private String y_position;
    private String y_phone;
    private String contract_name; //合同名称

    public String getContract_name() {
        return contract_name;
    }

    public void setContract_name(String contract_name) {
        this.contract_name = contract_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInvoice_type() {
        return invoice_type;
    }

    public void setInvoice_type(String invoice_type) {
        this.invoice_type = invoice_type;
    }

    public int getInvoice_number() {
        return invoice_number;
    }

    public void setInvoice_number(int invoice_number) {
        this.invoice_number = invoice_number;
    }

    public String getInvoice_date() {
        return invoice_date;
    }

    public void setInvoice_date(String invoice_date) {
        this.invoice_date = invoice_date;
    }

    public double getInvoice_money() {
        return invoice_money;
    }

    public void setInvoice_money(double invoice_money) {
        this.invoice_money = invoice_money;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getAccessory() {
        return accessory;
    }

    public void setAccessory(String accessory) {
        this.accessory = accessory;
    }

    public String getJ_linkman() {
        return j_linkman;
    }

    public void setJ_linkman(String j_linkman) {
        this.j_linkman = j_linkman;
    }

    public String getJ_position() {
        return j_position;
    }

    public void setJ_position(String j_position) {
        this.j_position = j_position;
    }

    public String getJ_phone() {
        return j_phone;
    }

    public void setJ_phone(String j_phone) {
        this.j_phone = j_phone;
    }

    public String getY_linkman() {
        return y_linkman;
    }

    public void setY_linkman(String y_linkman) {
        this.y_linkman = y_linkman;
    }

    public String getY_position() {
        return y_position;
    }

    public void setY_position(String y_position) {
        this.y_position = y_position;
    }

    public String getY_phone() {
        return y_phone;
    }

    public void setY_phone(String y_phone) {
        this.y_phone = y_phone;
    }
}
