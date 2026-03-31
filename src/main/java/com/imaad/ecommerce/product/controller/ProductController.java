package com.imaad.ecommerce.product.controller;

import com.imaad.ecommerce.product.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    public ResponseEntity<Product> getId(@PathVariable Long id) {
        Optional<Product> product = productService.getProductById(id);

        if(product.isPresent()) {
            return ResponseEntity.ok(product.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product newProduct) {
        Product savedProduct = productService.newProduct(newProduct);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        Optional<Product> deleted = productService.getProductById(id);
        
        if(deleted.isPresent()) {
            productService.deleteProduct(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
