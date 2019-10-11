package com.study.epamproject.domain.toy;

public class Ball extends Toy {
    private final int radius;
    private final String color;

    public Ball(Long id, String name, Integer price, Manufacturer manufacturer, int radius, String color) {
        super(id, name, price, manufacturer);
        this.radius = radius;
        this.color = color;
    }

    public int getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }
}
