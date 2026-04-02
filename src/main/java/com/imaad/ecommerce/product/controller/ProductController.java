package com.imaad.ecommerce.product.controller;

import com.imaad.ecommerce.product.repository.ProductRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.imaad.ecommerce.product.service.ProductService;
import com.imaad.ecommerce.product.Product;

import java.util.List;
import java.util.Optional;


@RestController
public class ProductController {

    private final ProductService productService;

    // Dependency Injection
    public ProductController(ProductService productService, ProductRepository productRepository) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    // @PathVariable makes Long id taken from {id} from path
    public Optional<Product> getId(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody Product newProduct) {
        return productService.newProduct(newProduct);
    }

    @PutMapping("/products/{id}")
    public Optional<Product> updateProduct(@RequestBody Product updatedProduct, @PathVariable Long id) {
        return productService.updateProduct(updatedProduct, id);
    }
    
    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}
