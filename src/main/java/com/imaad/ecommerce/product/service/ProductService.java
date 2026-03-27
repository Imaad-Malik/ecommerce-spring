package com.imaad.ecommerce.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.imaad.ecommerce.product.Product;

@Service
public class ProductService {

    public List<Product> getAllProducts() {
        return List.of(
                new Product("Laptop", 12.12, "Work Laptop"),
                new Product("PC", 1200.10, "Personal Computer"),
                new Product("TV", 1500.00, "Samsung television")
        );
    }

}
