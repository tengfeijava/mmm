package com.example.index.pojo;

import java.io.Serializable;
import java.util.List;

public class Bigbrand implements Serializable {


    private String name;
    private List<Brands> children;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Brands> getChildren() {
        return children;
    }

    public void setChildren(List<Brands> children) {
        this.children = children;
    }
}
