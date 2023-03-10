package org.example.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Order {
    static final String ANSI_CYAN = "\u001B[36m";
    static final String ANSI_RESET = "\u001B[0m";
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order order)) return false;
        return id == order.id && products.equals(order.products) && status == order.status && dateTime.equals(order.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, products, status, dateTime);
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", products=" + products + "," +
                ANSI_CYAN + " status=" + status + ANSI_RESET + ", dateTime=" + dateTime + '}' + "\n";
    }
}
