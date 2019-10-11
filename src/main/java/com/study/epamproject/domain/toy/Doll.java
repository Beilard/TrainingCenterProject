package com.study.epamproject.domain.toy;

public class Doll extends HumanoidFigurine {
    private final String clothesColor;

    public Doll(Long id, String name, Integer price, Manufacturer manufacturer, String gender, String skinColor, int numberOfLimbs, String clothesColor) {
        super(id, name, price, manufacturer, gender, skinColor, numberOfLimbs);
        this.clothesColor = clothesColor;
    }

    public String getClothesColor() {
        return clothesColor;
    }
}
