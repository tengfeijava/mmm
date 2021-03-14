package com.example.index.pojo;

import java.io.Serializable;

public class InstallDetails implements Serializable {
    private String contractname;
    private int count;
    private String elevatorClass;

    public String getContractname() {
        return contractname;
    }

    public void setContractname(String contractname) {
        this.contractname = contractname;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getElevatorClass() {
        return elevatorClass;
    }

    public void setElevatorClass(String elevatorClass) {
        this.elevatorClass = elevatorClass;
    }
}
