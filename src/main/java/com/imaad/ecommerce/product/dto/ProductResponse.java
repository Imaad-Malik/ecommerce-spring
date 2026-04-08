package com.imaad.ecommerce.product.dto;

public record ProductResponse(
    Long id,
    String name,
    Double price,
    String description
) {}
