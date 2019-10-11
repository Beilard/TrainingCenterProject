package com.study.epamproject.domain.toy;

public class Manufacturer {
    private final String name;
    private final int code;

    public Manufacturer(String name, int code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return name;
    }
}
