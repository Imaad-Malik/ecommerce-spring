package com.imaad.ecommerce.product.mapper;

import org.mapstruct.Mapper;

import com.imaad.ecommerce.product.Product;
import com.imaad.ecommerce.product.dto.ProductResponse;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductResponse mapToResponse(Product product);
}
