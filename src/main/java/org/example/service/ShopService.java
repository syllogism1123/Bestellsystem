package org.example.service;

import org.example.model.Order;
import org.example.model.Product;
import org.example.repository.OrderRepo;
import org.example.repository.ProductRepo;

import java.util.List;

public class ShopService {
    private OrderRepo orderRepo;
    private ProductRepo productRepo;

    public ShopService(OrderRepo orderRepo, ProductRepo productRepo) {
        this.orderRepo = orderRepo;
        this.productRepo = productRepo;
    }


    public Product getProductById(long id) {
        return productRepo.getProductById(id);
    }

    public List<Product> listProducts() {
        return productRepo.list();
    }

    public void addOrder(Order order) {
        orderRepo.add(order);
    }

    public Order getOrderById(long id) {

        return orderRepo.getOrderById(id);
    }

    public List<Order> listOrders() {
        return orderRepo.list();
    }


}
