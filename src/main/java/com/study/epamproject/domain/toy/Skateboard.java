package com.study.epamproject.domain.toy;

public class Skateboard extends MovableToy {
    private final int boardLength;

    public Skateboard(String name, Integer price, Manufacturer manufacturer, int numberOfWheels, int boardLength) {
        super(name, price, manufacturer, numberOfWheels);
        this.boardLength = boardLength;
    }

    public int getBoardLength() {
        return boardLength;
    }
}
