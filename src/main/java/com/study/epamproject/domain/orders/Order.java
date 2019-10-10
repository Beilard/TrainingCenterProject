package com.study.epamproject.domain.orders;

import com.study.epamproject.domain.toys.Toy;

import java.util.LinkedList;
import java.util.List;

public class Order {
    private final Long id;
    private List<? extends Toy> items = new LinkedList<>();


    public Order(Long id, List<? extends Toy> items) {
        this.id = id;
        this.items = items;
    }

    public List<? extends Toy> getItems() {
        return items;
    }
}
