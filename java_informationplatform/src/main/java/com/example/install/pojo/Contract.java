package com.example.install.pojo;

import java.math.BigDecimal;
import java.util.List;

public class Contract {
    private String id;
    private String contract_class;
    private String contract_name;
    private String supplier_name;
    private String contract_type;
    private String sign_date;
    private int counts; //总台数
    private String brands; //品牌
    private String cityd;//城市



    private Account account;
    private List<Details> detailsList;
    private List<Payment> paymentList;
    private List<Invoice> invoiceList;




    public int getCounts() {
        return counts;
    }

    public void setCounts(int counts) {
        this.counts = counts;
    }

    public String getBrands() {
        return brands;
    }

    public void setBrands(String brands) {
        this.brands = brands;
    }

    public String getCityd() {
        return cityd;
    }

    public void setCityd(String cityd) {
        this.cityd = cityd;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContract_class() {
        return contract_class;
    }

    public void setContract_class(String contract_class) {
        this.contract_class = contract_class;
    }

    public String getContract_name() {
        return contract_name;
    }

    public void setContract_name(String contract_name) {
        this.contract_name = contract_name;
    }

    public String getSupplier_name() {
        return supplier_name;
    }

    public void setSupplier_name(String supplier_name) {
        this.supplier_name = supplier_name;
    }

    public String getContract_type() {
        return contract_type;
    }

    public void setContract_type(String contract_type) {
        this.contract_type = contract_type;
    }

    public String getSign_date() {
        return sign_date;
    }

    public void setSign_date(String sign_date) {
        this.sign_date = sign_date;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<Details> getDetailsList() {
        return detailsList;
    }

    public void setDetailsList(List<Details> detailsList) {
        this.detailsList = detailsList;
    }

    public List<Invoice> getInvoiceList() {
        return invoiceList;
    }

    public void setInvoiceList(List<Invoice> invoiceList) {
        this.invoiceList = invoiceList;
    }

    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "id='" + id + '\'' +
                ", contract_class='" + contract_class + '\'' +
                ", contract_name='" + contract_name + '\'' +
                ", supplier_name='" + supplier_name + '\'' +
                ", contract_type='" + contract_type + '\'' +
                ", sign_date='" + sign_date + '\'' +
                ", accountList=" + account +
                ", detailsList=" + detailsList +
                ", invoiceList=" + invoiceList +
                ", paymentList=" + paymentList +
                '}';
    }

    //    private String contract_num;
//    private String end_state;
//    private double account_sum;
//    private String end_time;
//    private String check_state;
//    private String check_state_now;
//    private String check_state_next;
//    private String contract_state;
//    private String creator;
//    private String create_time;
//    private double quality_gold;
//    private double imprest;
//    private String stamp_tax;
//    private String currency;
//    private String start_time;
//    private String type_pro;
//    private String content_text;
//    private double tax_rate;
//    private String department;
//    private String remark;
//    private String range_note;
//    private String imprest_note;
//    private double imprest_brokerage;
//    private String guarantee_note;
//    private String guaranteeTime_note;
}
