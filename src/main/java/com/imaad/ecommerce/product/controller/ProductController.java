package com.imaad.ecommerce.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imaad.ecommerce.product.service.ProductService;
import com.imaad.ecommerce.product.Product;
import java.util.List;


@RestController
public class ProductController {

    private final ProductService productService;

    // Dependency Injection
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }
}
