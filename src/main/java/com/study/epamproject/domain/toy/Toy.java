package com.study.epamproject.domain.toy;

import java.util.Objects;

public abstract class Toy implements Comparable<Toy>{
    private Long id;
    private final String name;
    private final Integer price;
    private final Manufacturer manufacturer;

    public Toy(Long id, String name, Integer price, Manufacturer manufacturer) {
        this.id = id;
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

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Toy)) {
            return false;
        }
        Toy toy = (Toy) o;
        return Objects.equals(id, toy.id) &&
                Objects.equals(name, toy.name) &&
                Objects.equals(price, toy.price) &&
                Objects.equals(manufacturer, toy.manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, manufacturer);
    }
}
