package org.example;

import org.example.model.Order;
import org.example.model.Product;
import org.example.repository.OrderRepo;
import org.example.repository.OrderRepoImp;
import org.example.repository.ProductRepo;
import org.example.repository.ProductRepoImp;
import org.example.service.ShopService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.example.model.OrderStatus.*;


public class Main {
    public static void main(String[] args) {
        Product p1 = new Product(11, "Paper");
        Product p2 = new Product(22, "Pencil");
        Product p3 = new Product(33, "Eraser");
        List<Order> orders = new ArrayList<>();
        Order order = new Order(1, List.of(p1, p2), COMPLETED,
                LocalDateTime.of(2023, 3, 9, 10, 30, 15));
        orders.add(order);
        OrderRepo orderRepo = new OrderRepoImp(orders);
        ProductRepo productRepo = new ProductRepoImp(List.of(p1, p2, p3));
        ShopService service = new ShopService(orderRepo, productRepo);

        System.out.println("Options: enter A for display all products, " +
                "S for display single product " + "ADD for add a new order");
        try (Scanner scanner = new Scanner(System.in)) {
            String input = scanner.nextLine();
            switch (input.toUpperCase()) {
                case "A" -> System.out.println(service.listProducts());
                case "S" -> {
                    System.out.println("please enter Product's Id ");
                    input = scanner.nextLine();
                    System.out.println(service.getProductById(Long.parseLong(input)));
                }
                case "ADD" -> {
                    List<Product> products = new ArrayList<>();
                    while (true) {
                        System.out.println("please enter your new Product's Id");
                        input = scanner.nextLine();
                        System.out.println(service.listProducts());
                        Product p = service.getProductById(Long.parseLong(input));
                        products.add(p);
                        System.out.println("Enter Y for add a new one Enter N for quit ");
                        input = scanner.nextLine();
                        if (input.equalsIgnoreCase("Y")) {

                        } else if (input.equalsIgnoreCase("N")) {
                            break;
                        } else {
                            break;
                        }
                    }
                    System.out.println("please enter your new Order's Id");
                    input = scanner.nextLine();
                    Order newOrder = new Order(Long.parseLong(input), products, IN_PROGRESS,
                            LocalDateTime.of(2023, 3, 10, 12, 30, 15));
                    service.addOrder(newOrder);
                    System.out.println("newOrder: " + newOrder);
                    System.out.println("allOrders:" + service.listOrders());
                }
                default -> System.out.println("Invalid input");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}






