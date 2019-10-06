package com.study.epamproject.domain.toys;

public abstract class HumanoidFigurine extends Figurine {
    private final String gender;
    private final String skinColor;

    public HumanoidFigurine(String name, Integer price, Manufacturer manufacturer, int numberOfLimbs, String gender, String skinColor) {
        super(name, price, manufacturer, numberOfLimbs);
        this.gender = gender;
        this.skinColor = skinColor;
    }
}
