package com.example.index.pojo;

import java.io.Serializable;

public class Brandlog implements Serializable {

    private String brandAccessory;
    private String Brand;
    private int brandNumber;



    public String getBrandAccessory() {
        return brandAccessory;
    }

    public void setBrandAccessory(String brandAccessory) {
        this.brandAccessory = brandAccessory;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public int getBrandNumber() {
        return brandNumber;
    }

    public void setBrandNumber(int brandNumber) {
        this.brandNumber = brandNumber;
    }
}
