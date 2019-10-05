package com.study.epamproject.domain.toys;

public class ElectronicToy extends Toy {
    private final long ramSize;

    public ElectronicToy(String name, Integer price, Manufacturer manufacturer, long ramSize) {
        super(name, price, manufacturer);
        this.ramSize = ramSize;
    }
}
