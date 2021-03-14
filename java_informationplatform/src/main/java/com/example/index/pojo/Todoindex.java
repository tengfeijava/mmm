package com.example.index.pojo;

import java.io.Serializable;
import java.util.List;

public class Todoindex implements Serializable {

    private int id;
    private String project_name;
    private String project_class;  //plan 计划  remind 提醒

    private int maintenance_sum;
    private double maintenance_income;
    private double maintenance_expend;




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getProject_class() {
        return project_class;
    }

    public void setProject_class(String project_class) {
        this.project_class = project_class;
    }



}
