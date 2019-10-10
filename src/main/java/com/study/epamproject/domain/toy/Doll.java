package com.study.epamproject.domain.toy;

public class Doll extends HumanoidFigurine {
    private final String clothesColor;

    public Doll(String name, Integer price, Manufacturer manufacturer, String gender, String skinColor, int numberOfLimbs, String clothesColor) {
        super(name, price, manufacturer, gender, skinColor, numberOfLimbs);
        this.clothesColor = clothesColor;
    }

    public String getClothesColor() {
        return clothesColor;
    }
}
