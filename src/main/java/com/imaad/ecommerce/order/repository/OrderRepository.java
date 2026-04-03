package com.imaad.ecommerce.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imaad.ecommerce.order.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
