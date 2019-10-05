package com.study.epamproject.domain;

public abstract class HumanoidFigurine extends Figurine {
    private final String gender;
    private final String skinColor;

    public HumanoidFigurine(String name, Integer price, Manufacturer manufacturer, int numberOfLimbs, String gender, String gender1, String skinColor) {
        super(name, price, manufacturer, numberOfLimbs, gender);
        this.gender = gender1;
        this.skinColor = skinColor;
    }
}
