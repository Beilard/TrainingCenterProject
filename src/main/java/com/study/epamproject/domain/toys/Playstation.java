package com.study.epamproject.domain.toys;

public class Playstation extends ElectronicToy{
    private final int consoleVersion;

    public Playstation(String name, Integer price, Manufacturer manufacturer, long ramSize, int consoleVersion) {
        super(name, price, manufacturer, ramSize);
        this.consoleVersion = consoleVersion;
    }
}
