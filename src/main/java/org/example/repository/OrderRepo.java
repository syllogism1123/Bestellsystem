package org.example.repository;

import org.example.model.Order;

import java.util.List;

public interface OrderRepo {
    List<Order> list();

    Order getOrderById(long id);

    void add(Order order);
}
