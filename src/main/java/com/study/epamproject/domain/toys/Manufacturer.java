package com.study.epamproject.domain.toys;

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
}
