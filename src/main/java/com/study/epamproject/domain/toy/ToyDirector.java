package com.study.epamproject.domain.toy;

public class ToyDirector {

    public static Toy createBaseball(){
        return new Ball(0L, "Baseball", 400, new Manufacturer("Nike", 0), 10, "white");
    }

    public static Toy createFootball(){
        return new Ball(1L, "Football", 500, new Manufacturer("Nike", 0), 10, "black");
    }

    public static Toy createSkateboard(){
        return new Skateboard(2L, "Longboard", 1000, new Manufacturer("Boards", 1), 4, 100);
    }

    public static Toy createHoverboard(){
        return new Skateboard(2L, "Hoverboard", 2000, new Manufacturer("Boards", 1), 0, 100);
    }


}
