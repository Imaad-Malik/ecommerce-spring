package com.imaad.ecommerce.order.service;

import java.util.List;

import org.mapstruct.factory.Mappers;

import org.springframework.stereotype.Service;

import com.imaad.ecommerce.order.Order;
import com.imaad.ecommerce.order.dto.CreateOrderRequest;
import com.imaad.ecommerce.order.dto.OrderResponse;
import com.imaad.ecommerce.order.dto.UpdateOrderRequest;
import com.imaad.ecommerce.order.mapper.OrderMapper;
import com.imaad.ecommerce.order.repository.OrderRepository;
import com.imaad.ecommerce.product.Product;
import com.imaad.ecommerce.product.repository.ProductRepository;

@Service
public class OrderService {
    
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private OrderMapper orderMapper = Mappers.getMapper(OrderMapper.class);

    public OrderService(OrderRepository orderRepositroy,ProductRepository productRepository) 
    {
        this.orderRepository = orderRepositroy;
        this.productRepository = productRepository;
    }

    public OrderResponse createOrder(CreateOrderRequest request) 
    {
         // Get product from DB and make sure it exists
        Product product = productRepository.findById(request.productId())
            .orElseThrow(() -> new IllegalArgumentException("Product not found."));

        Order order = new Order(product, request.quantity());
        Order saved = orderRepository.save(order);

        return orderMapper.mapToResponse(saved);
    }

    public List<OrderResponse> getAllOrders() 
    {
        return orderRepository.findAll()
            .stream()
            .map(order -> orderMapper.mapToResponse(order))
            .toList();
    }

    public void deleteOrder(Long id) 
    {
        Order order = orderRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Order not found."));
        
        orderRepository.delete(order);
    }


    /*
        Find order by provided param Long id
        Need to take updatedOrder productId and quantity and use it to update it
    */
    public OrderResponse updateOrder(UpdateOrderRequest updatedOrder, Long id) 
    {
        Order order = orderRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Order not found."));

        Product product = productRepository.findById(updatedOrder.productId())
            .orElseThrow(() -> new IllegalArgumentException("Product not found"));

        order.setProduct(product);
        order.setQuantity(updatedOrder.quantity());

        Order saved = orderRepository.save(order);

        return orderMapper.mapToResponse(saved);
    }
}
