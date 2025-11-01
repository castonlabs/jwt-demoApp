package com.jwtapp.jwtappdemo.repository;

import com.jwtapp.jwtappdemo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepositoryInterf extends JpaRepository<Product, Long> {
}
