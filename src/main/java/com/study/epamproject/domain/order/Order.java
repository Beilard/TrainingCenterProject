package com.study.epamproject.domain.order;

import com.study.epamproject.domain.toy.Toy;

import java.util.LinkedList;
import java.util.List;

public class Order {
    private final Long id;
    private List<Toy> items = new LinkedList<>();


    public Order(Long id) {
        this.id = id;
    }

    public List<Toy> getItems() {
        return items;
    }

    public Long getId() {
        return id;
    }

    public void addToy(Toy toy) {
        items.add(toy);
    }
    public void removeToy(Toy toy){
        items.remove(toy);
    }
}
