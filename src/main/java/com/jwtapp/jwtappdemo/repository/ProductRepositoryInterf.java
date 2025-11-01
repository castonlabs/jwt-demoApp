package com.jwtapp.jwtappdemo.repository;

import com.jwtapp.jwtappdemo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepositoryInterf extends JpaRepository<Product, Long> {
}
