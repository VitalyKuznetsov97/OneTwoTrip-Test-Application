package com.vitaly_kuznetsov.onetwotriptestapplication.domain.entity;

public class Company implements Entity{

    private int id;
    private String name;

    // Getter Methods

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // Setter Methods

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
