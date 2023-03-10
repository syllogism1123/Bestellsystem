package org.example.repository;

import org.example.model.Product;

import java.util.List;

public interface ProductRepo {
    List<Product> list();

    Product getProductById(long id);
}
