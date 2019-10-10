package com.study.epamproject.domain.toys;

public class Doll extends HumanoidFigurine {
    private final String clothesColor;

    public Doll(String name, Integer price, Manufacturer manufacturer, int numberOfLimbs, String gender, String skinColor, String clothesColor) {
        super(name, price, manufacturer, numberOfLimbs, gender, skinColor);
        this.clothesColor = clothesColor;
    }

    public String getClothesColor() {
        return clothesColor;
    }
}
