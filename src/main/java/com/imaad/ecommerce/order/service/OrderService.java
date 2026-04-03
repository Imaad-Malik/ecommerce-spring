package com.imaad.ecommerce.order.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.imaad.ecommerce.order.Order;
import com.imaad.ecommerce.order.repository.OrderRepository;
import com.imaad.ecommerce.product.repository.ProductRepository;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderService(OrderRepository orderRepositroy,ProductRepository productRepository) {
        this.orderRepository = orderRepositroy;
        this.productRepository = productRepository;
    }

    public Order createOrder(Long productId, int quantity) {
        
        // Check if product exists, else throw exception
        productRepository.findById(productId).orElseThrow(
            () -> new IllegalArgumentException("Product not found by ID " + productId));

        Order order = new Order(productId, quantity);
        
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    public Optional<Order> updateOrder(Order updatedOrder, Long id) {
        return orderRepository.findById(id)
            .map(order -> {
                order.setProductId(updatedOrder.getProductId());
                order.setQuantity(updatedOrder.getQuantity());
                order.setCreatedAt(updatedOrder.getCreatedAt());
                return orderRepository.save(order);
            });
    }
}
