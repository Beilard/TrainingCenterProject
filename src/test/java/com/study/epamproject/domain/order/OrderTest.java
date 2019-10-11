package com.study.epamproject.domain.order;

import com.study.epamproject.domain.toy.Ball;
import com.study.epamproject.domain.toy.Manufacturer;
import com.study.epamproject.domain.toy.Toy;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class OrderTest {
    private List<Toy> toys = new LinkedList<>();
    private Order order;
    Ball ball = new Ball(1L,"Ball", 100, new Manufacturer("Nike", 0), 10, "Red");

    @Before
    public void setup() {
       order = new Order(0L);
    }

    @Test
    public void addShouldHaveNormalBehaviour() {
        order.addToy(ball);
        assertEquals(order.getItems().get(0), ball);
    }

    @Test
    public void removeToy() {
        order.addToy(ball);
        order.removeToy(ball);
        assertEquals(order.getItems().size(), 0);
    }
}