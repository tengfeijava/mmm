package com.example.user.pojo;

import java.io.Serializable;

public class Clerk implements Serializable {
    private int id;
    private String clerk_name;             //姓名
    private String clerk_number;           //工号
    private String clerk_section;          //部门
    private String clerk_position;         //职位
    private String clerk_phone;            //电话
    private String clerk_place;            //籍贯
    private String clerk_identity_card;    //身份证
    private String clerk_start_date;       //签订日期
    private String clerk_termination_date;//终止日期
    private String clerk_official_date;    //转正日期
    private String clerk_urgency_phone;    //紧急联系人电话
    private String clerk_school;            //学历
    private String clerk_gradation;         //职员层次
    private String clerk_comment;           //备注\

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClerk_name() {
        return clerk_name;
    }

    public void setClerk_name(String clerk_name) {
        this.clerk_name = clerk_name;
    }

    public String getClerk_number() {
        return clerk_number;
    }

    public void setClerk_number(String clerk_number) {
        this.clerk_number = clerk_number;
    }

    public String getClerk_section() {
        return clerk_section;
    }

    public void setClerk_section(String clerk_section) {
        this.clerk_section = clerk_section;
    }

    public String getClerk_position() {
        return clerk_position;
    }

    public void setClerk_position(String clerk_position) {
        this.clerk_position = clerk_position;
    }

    public String getClerk_phone() {
        return clerk_phone;
    }

    public void setClerk_phone(String clerk_phone) {
        this.clerk_phone = clerk_phone;
    }

    public String getClerk_place() {
        return clerk_place;
    }

    public void setClerk_place(String clerk_place) {
        this.clerk_place = clerk_place;
    }

    public String getClerk_identity_card() {
        return clerk_identity_card;
    }

    public void setClerk_identity_card(String clerk_identity_card) {
        this.clerk_identity_card = clerk_identity_card;
    }

    public String getClerk_start_date() {
        return clerk_start_date;
    }

    public void setClerk_start_date(String clerk_start_date) {
        this.clerk_start_date = clerk_start_date;
    }

    public String getClerk_termination_date() {
        return clerk_termination_date;
    }

    public void setClerk_termination_date(String clerk_termination_date) {
        this.clerk_termination_date = clerk_termination_date;
    }

    public String getClerk_official_date() {
        return clerk_official_date;
    }

    public void setClerk_official_date(String clerk_official_date) {
        this.clerk_official_date = clerk_official_date;
    }

    public String getClerk_urgency_phone() {
        return clerk_urgency_phone;
    }

    public void setClerk_urgency_phone(String clerk_urgency_phone) {
        this.clerk_urgency_phone = clerk_urgency_phone;
    }

    public String getClerk_school() {
        return clerk_school;
    }

    public void setClerk_school(String clerk_school) {
        this.clerk_school = clerk_school;
    }

    public String getClerk_gradation() {
        return clerk_gradation;
    }

    public void setClerk_gradation(String clerk_gradation) {
        this.clerk_gradation = clerk_gradation;
    }

    public String getClerk_comment() {
        return clerk_comment;
    }

    public void setClerk_comment(String clerk_comment) {
        this.clerk_comment = clerk_comment;
    }
}
