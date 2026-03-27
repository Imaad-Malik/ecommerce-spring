package com.imaad.ecommerce.product.repository;

import com.imaad.ecommerce.product.Product;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
