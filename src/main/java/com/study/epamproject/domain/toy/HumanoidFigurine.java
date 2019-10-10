package com.study.epamproject.domain.toy;

public abstract class HumanoidFigurine extends Toy {
    private final String gender;
    private final String skinColor;
    private final int numberOfLimbs;

    public HumanoidFigurine(String name, Integer price, Manufacturer manufacturer, String gender, String skinColor, int numberOfLimbs) {
        super(name, price, manufacturer);
        this.gender = gender;
        this.skinColor = skinColor;
        this.numberOfLimbs = numberOfLimbs;
    }

    public String getGender() {
        return gender;
    }

    public String getSkinColor() {
        return skinColor;
    }

    public int getNumberOfLimbs() {
        return numberOfLimbs;
    }
}

