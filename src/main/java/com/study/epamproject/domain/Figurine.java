package com.study.epamproject.domain;

public abstract class Figurine extends Toy {
    private final int numberOfLimbs;
    private final String gender;

    public Figurine(String name, Integer price, Manufacturer manufacturer, int numberOfLimbs, String gender) {
        super(name, price, manufacturer);
        this.numberOfLimbs = numberOfLimbs;
        this.gender = gender;
    }

    public int getNumberOfLimbs() {
        return numberOfLimbs;
    }

    public String getGender() {
        return gender;
    }
}
