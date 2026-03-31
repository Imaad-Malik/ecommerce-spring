package com.imaad.ecommerce.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.imaad.ecommerce.product.Product;
import com.imaad.ecommerce.product.repository.ProductRepository;

import jakarta.annotation.PostConstruct;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostConstruct
    public void init() {
        productRepository.save(new Product("Laptop", 12.12, "Work Laptop"));
        productRepository.save(new Product("Laptop2", 12.12, "Work Laptop"));
        productRepository.save(new Product("Laptop3", 12.12, "Work Laptop"));
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product newProduct(Product newProduct) {
        return productRepository.save(newProduct);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
