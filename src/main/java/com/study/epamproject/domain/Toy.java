package com.study.epamproject.domain;

public abstract class Toy {
    private Long id;
    private final String name;
    private final Integer price;
    private final Manufacturer manufacturer;

    public Toy(String name, Integer price, Manufacturer manufacturer) {
        this.name = name;
        this.price = price;
        this.manufacturer = manufacturer;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }
}
