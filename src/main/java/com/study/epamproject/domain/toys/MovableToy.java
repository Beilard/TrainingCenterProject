package com.study.epamproject.domain.toys;

public class MovableToy extends Toy{
    private final int numberOfWheels;

    public MovableToy(String name, Integer price, Manufacturer manufacturer, int numberOfWheels) {
        super(name, price, manufacturer);
        this.numberOfWheels = numberOfWheels;
    }

    public int getNumberOfWheels() {
        return numberOfWheels;
    }
}