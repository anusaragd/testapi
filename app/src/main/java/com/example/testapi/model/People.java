package com.example.testapi.model;

import java.io.Serializable;

public class People implements Serializable {


    private static final long serialVersionUID = 3359996873885112880L;

    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
