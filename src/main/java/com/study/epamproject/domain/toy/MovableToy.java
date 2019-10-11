package com.study.epamproject.domain.toy;

public class MovableToy extends Toy{
    private final int numberOfWheels;

    public MovableToy(Long id, String name, Integer price, Manufacturer manufacturer, int numberOfWheels) {
        super(id, name, price, manufacturer);
        this.numberOfWheels = numberOfWheels;
    }

    public int getNumberOfWheels() {
        return numberOfWheels;
    }
}
