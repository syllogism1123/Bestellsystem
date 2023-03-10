package org.example.model;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private long id;
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    private OrderStatus status;

    private LocalDateTime dateTime;

    public Order(long id, List<Product> products) {
        this.id = id;
        this.products = products;
    }

    public Order(long id, List<Product> products, OrderStatus status, LocalDateTime dateTime) {
        this.id = id;
        this.products = products;
        this.status = status;
        this.dateTime = dateTime;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", products=" + products + "," +
                " status=" + status + ", dateTime=" + dateTime + '}' + "\n";
    }
}
