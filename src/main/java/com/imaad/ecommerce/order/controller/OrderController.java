package com.imaad.ecommerce.order.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.imaad.ecommerce.order.dto.CreateOrderRequest;
import com.imaad.ecommerce.order.dto.OrderResponse;
import com.imaad.ecommerce.order.dto.UpdateOrderRequest;
import com.imaad.ecommerce.order.service.OrderService;

import java.util.List;

@RestController
public class OrderController 
{
    
    private final OrderService orderService;
    
    public OrderController(OrderService orderService) 
    {
        this.orderService = orderService;
    }

    @PostMapping("/orders")
    public OrderResponse createOrder(@RequestBody CreateOrderRequest request) 
    {
        return orderService.createOrder(request);
    }

    @GetMapping("/orders")
    public List<OrderResponse> getOrders() 
    {
        return orderService.getAllOrders();
    }

    @DeleteMapping("/orders/{id}")
    public void deleteOrder(@PathVariable Long id) 
    {
        orderService.deleteOrder(id);
    }

    @PutMapping("/orders/{id}")
    public OrderResponse updatedOrder(@RequestBody UpdateOrderRequest updateOrder, @PathVariable Long id) 
    {
        return orderService.updateOrder(updateOrder, id);
    }
}
