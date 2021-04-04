package com.chrisvasqm.model;

public class Character {
    private final String name;
    private final String portrayed;

    public Character(String name, String portrayed) {
        this.name = name;
        this.portrayed = portrayed;
    }

    public String getName() {
        return name;
    }

    public String getPortrayed() {
        return portrayed;
    }

}
