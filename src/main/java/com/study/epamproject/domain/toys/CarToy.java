package com.study.epamproject.domain.toys;

public class CarToy extends MovableToy {
    private final String CarModel;

    public CarToy(String name, Integer price, Manufacturer manufacturer, int numberOfWheels, String carModel) {
        super(name, price, manufacturer, numberOfWheels);
        CarModel = carModel;
    }

    public String getCarModel() {
        return CarModel;
    }
}
