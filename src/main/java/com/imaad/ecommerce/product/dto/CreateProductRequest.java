package com.imaad.ecommerce.product.dto;

public record CreateProductRequest(
    Long id,
    String name,
    Double price,
    String description
) {}
