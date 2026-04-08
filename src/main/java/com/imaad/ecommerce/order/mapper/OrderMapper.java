package com.imaad.ecommerce.order.mapper;

import org.mapstruct.Mapper;

import com.imaad.ecommerce.order.Order;
import com.imaad.ecommerce.order.dto.OrderResponse;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderResponse mapToResponse(Order Order);
}
