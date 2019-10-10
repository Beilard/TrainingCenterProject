package com.study.epamproject.domain.users;

public final class Address {
    private final String city;
    private final String postalCode;

    protected Address(String city, String postalCode) {
        this.city = city;
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }
}
