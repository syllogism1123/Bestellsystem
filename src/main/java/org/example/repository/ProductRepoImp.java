package org.example.repository;

import org.example.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ProductRepoImp implements ProductRepo {
    private List<Product> products;

    public ProductRepoImp() {
    }

    public ProductRepoImp(List<Product> products) {
        this.products = products;
    }


    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public List<Product> list() {
        return new ArrayList<>(products);
    }

    @Override
    public Product getProductById(long id) {
        for (Product p : products) {
            if (p.getId() == id) {
                return p;
            }
        }
        throw new NoSuchElementException("This Product does not exist.");
    }

}
