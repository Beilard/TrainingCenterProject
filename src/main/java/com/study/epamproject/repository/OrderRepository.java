package com.study.epamproject.repository;

import com.study.epamproject.domain.orders.Order;

public interface OrderRepository<E extends Order> extends CrudRepository<E> {

}
