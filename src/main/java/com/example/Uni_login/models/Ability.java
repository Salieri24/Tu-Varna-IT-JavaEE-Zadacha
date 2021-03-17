package com.example.Uni_login.models;

public class Ability {  //name of the ability and thel value-max : 100%
    private String name;
    private int percentage;

    public Ability(String name, int percentage) {
        this.name = name;
        this.percentage = percentage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }
}
