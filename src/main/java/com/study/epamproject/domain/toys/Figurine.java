package com.study.epamproject.domain.toys;

public abstract class Figurine extends Toy {
    private final int numberOfLimbs;

    public Figurine(String name, Integer price, Manufacturer manufacturer, int numberOfLimbs) {
        super(name, price, manufacturer);
        this.numberOfLimbs = numberOfLimbs;
    }

    public int getNumberOfLimbs() {
        return numberOfLimbs;
    }

}
