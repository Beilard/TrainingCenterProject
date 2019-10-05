package com.study.epamproject.domain.toys;

public class ActionFigure extends HumanoidFigurine {
    private final Weapon weapon;

    public ActionFigure(String name, Integer price, Manufacturer manufacturer, int numberOfLimbs, String gender, String gender1, String skinColor, Weapon weapon) {
        super(name, price, manufacturer, numberOfLimbs, gender, gender1, skinColor);
        this.weapon = weapon;
    }
}
