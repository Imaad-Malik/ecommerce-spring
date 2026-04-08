package com.imaad.ecommerce.product.service;

import java.util.List;
import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import com.imaad.ecommerce.product.Product;
import com.imaad.ecommerce.product.dto.CreateProductRequest;
import com.imaad.ecommerce.product.dto.ProductResponse;
import com.imaad.ecommerce.product.dto.UpdateProductRequest;
import com.imaad.ecommerce.product.mapper.ProductMapper;
import com.imaad.ecommerce.product.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private ProductMapper productMapper = Mappers.getMapper(ProductMapper.class);

    public ProductService(ProductRepository productRepository) 
    {
        this.productRepository = productRepository;
    }

    public List<ProductResponse> getAllProducts() 
    {    
        return productRepository.findAll()
            .stream()
            .map(product -> productMapper.mapToResponse(product))
            .toList();
    }

    public ProductResponse getProductById(Long id) 
    {    
        Product product = productRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Product not found."));
        
        ProductResponse productResponse = productMapper.mapToResponse(product);

        return productResponse;
    }
    
    public ProductResponse createProduct(CreateProductRequest newProduct) 
    {    
        Product product = new Product(
            newProduct.name(),
            newProduct.price(),
            newProduct.description());

        Product saved = productRepository.save(product);

        return productMapper.mapToResponse(saved);     
    }

    public ProductResponse updateProduct(UpdateProductRequest updatedProduct, Long id) 
    {
        Product product = productRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Product not found."));

        product.setName(updatedProduct.name());
        product.setPrice(updatedProduct.price());
        product.setDescription(updatedProduct.description());

        Product saved = productRepository.save(product);

        return productMapper.mapToResponse(saved);
    }

    public void deleteProduct(Long id) 
    {
        Product product = productRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Product not found."));
        
        productRepository.delete(product);
    }
}
