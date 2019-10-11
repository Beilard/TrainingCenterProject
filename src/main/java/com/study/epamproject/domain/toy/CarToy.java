package com.study.epamproject.domain.toy;

public class CarToy extends MovableToy {
    private final String CarModel;

    public CarToy(Long id, String name, Integer price, Manufacturer manufacturer, int numberOfWheels, String carModel) {
        super(id, name, price, manufacturer, numberOfWheels);
        CarModel = carModel;
    }

    public String getCarModel() {
        return CarModel;
    }
}
