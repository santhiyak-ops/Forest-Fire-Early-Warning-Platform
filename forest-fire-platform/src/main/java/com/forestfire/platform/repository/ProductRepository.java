package com.forestfire.platform.repository;

import com.forestfire.platform.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {
}
