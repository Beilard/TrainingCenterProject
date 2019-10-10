package com.study.epamproject.domain.order;

import com.study.epamproject.domain.toy.Toy;

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

    public Long getId() {
        return id;
    }
}
