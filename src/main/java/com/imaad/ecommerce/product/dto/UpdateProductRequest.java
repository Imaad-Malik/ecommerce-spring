package com.imaad.ecommerce.product.dto;

public record UpdateProductRequest(
    Long id,
    String name,
    Double price,
    String description
) {}
