package org.example.repository;

import org.example.model.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class OrderRepoImp implements OrderRepo {
    private List<Order> orders;

    public OrderRepoImp() {
    }

    public OrderRepoImp(List<Order> orders) {
        this.orders = orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public List<Order> list() {
        return new ArrayList<>(orders);
    }

    @Override
    public Order getOrderById(long id) {

        for (Order o : orders) {
            if (o.getId() == id) {
                return o;
            }
        }
        throw new NoSuchElementException("This Order does not exist.");
    }

    @Override
    public void add(Order order) {
        orders.add(order);
    }

}
