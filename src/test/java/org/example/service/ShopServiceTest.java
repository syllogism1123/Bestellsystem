package org.example.service;

import org.example.model.Order;
import org.example.model.Product;
import org.example.repository.OrderRepo;
import org.example.repository.OrderRepoImp;
import org.example.repository.ProductRepo;
import org.example.repository.ProductRepoImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.example.model.OrderStatus.COMPLETED;


class ShopServiceTest {
    private ShopService service;
    private OrderRepo orderRepo;
    private ProductRepo productRepo;


    @BeforeEach
    void setup() {
        Product p1 = new Product(11, "Paper");
        Product p2 = new Product(22, "Pencil");
        Product p3 = new Product(33, "Eraser");
        List<Order> orders = new ArrayList<>();
        Order order = new Order(1, List.of(p1, p2), COMPLETED,
                LocalDateTime.of(2023, 3, 9, 10, 30, 15));
        orders.add(order);
        orderRepo = new OrderRepoImp(orders);
        productRepo = new ProductRepoImp(List.of(p1, p2, p3));
        service = new ShopService(orderRepo, productRepo);
    }


    @Test
    void testGetProductById() {
        assertThat(service.getProductById(11).getName())
                .startsWith("Pa")
                .endsWith("per")
                .isEqualToIgnoringCase("Paper");
    }

    @Test
    void testListProducts() {
        assertThat(service.listProducts())
                .hasSize(3)
                .contains(new Product(11, "Paper"),
                        new Product(22, "Pencil"),
                        new Product(33, "Eraser"));
    }

    @Test
    void testAddOrder() {


    }

    @Test
    void testGetOrderById() {
        assertThat(service.getOrderById(1).getStatus().getState())
                .isEqualToIgnoringCase("Completed");
    }

    @Test
    void testListOrders() {
        assertThat(service.listOrders())
                .hasSize(1)
                .contains(new Order(1, List.of(new Product(11, "Paper"),
                        new Product(22, "Pencil")), COMPLETED,
                        LocalDateTime.of(2023, 3, 9, 10, 30, 15)));
    }
}