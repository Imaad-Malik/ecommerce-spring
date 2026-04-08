package com.imaad.ecommerce.product.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.imaad.ecommerce.product.dto.CreateProductRequest;
import com.imaad.ecommerce.product.dto.ProductResponse;
import com.imaad.ecommerce.product.dto.UpdateProductRequest;
import com.imaad.ecommerce.product.service.ProductService;

import java.util.List;


@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<ProductResponse> getProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public ProductResponse getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping("/products")
    public ProductResponse createProduct(@RequestBody CreateProductRequest newProduct) {
        return productService.createProduct(newProduct);
    }

    @PutMapping("/products/{id}")
    public ProductResponse updateProduct(@RequestBody UpdateProductRequest updatedProduct, @PathVariable Long id) {
        return productService.updateProduct(updatedProduct, id);
    }
    
    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}
