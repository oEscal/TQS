package com.example.carAPI;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;


@Entity
public class Car {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String maker;

    public Car() {
    }

    public Car(String name, String maker) {
        this.name = name;
        this.maker = maker;
    }

    public String getName() {
        return name;
    }

    public String getMaker() {
        return maker;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }
}
