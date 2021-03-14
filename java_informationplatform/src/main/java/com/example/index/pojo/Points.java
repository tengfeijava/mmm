package com.example.index.pojo;

import java.io.Serializable;
import java.util.List;

public class Points implements Serializable {
    private int id;
    private String name;
    private List<Pointss> location;

    public List<Pointss> getLocation() {
        return location;
    }

    public void setLocation(List<Pointss> location) {
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
