package com.study.epamproject.domain.toy;

public abstract class Toy implements Comparable<Toy>{
    private Long id;
    private final String name;
    private final Integer price;
    private final Manufacturer manufacturer;

    public Toy(String name, Integer price, Manufacturer manufacturer) {
        this.name = name;
        this.price = price;
        this.manufacturer = manufacturer;
    }

    public int compareTo(Toy toy) {
        if (price == toy.price) {
            return 0;
        } else if (price > toy.price) {
            return 1;
        } else {
            return -1;
        }
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
