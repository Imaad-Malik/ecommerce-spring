package com.imaad.ecommerce.order.dto;

public record OrderResponse(
    Long id,
    Long productId,
    String productName,
    Double productPrice,
    int quantity
) {}
