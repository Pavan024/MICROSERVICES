package com.wavelabs.service2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wavelabs.service2.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    Product findByName(String name);
}

