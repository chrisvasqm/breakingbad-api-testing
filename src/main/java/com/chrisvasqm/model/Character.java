package com.chrisvasqm.model;

public class Character {
    private  String name;
    private  String portrayed;

    public Character(String name, String portrayed) {
        this.name = name;
        this.portrayed = portrayed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPortrayed(String portrayed) {
        this.portrayed = portrayed;
    }
    public String getName() {
        return name;
    }

    public String getPortrayed() {
        return portrayed;
    }

}
