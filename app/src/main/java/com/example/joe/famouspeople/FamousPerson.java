package com.example.joe.famouspeople;

import java.io.Serializable;

public class FamousPerson implements Serializable{

    private String name;
    private String gender;
    private String field;
    private boolean isAlive;

    public FamousPerson(String name, String gender, String field, boolean isAlive) {
        this.name = name;
        this.gender = gender;
        this.field = field;
        this.isAlive = isAlive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }


}