package com.jwtapp.jwtappdemo.service;

import com.jwtapp.jwtappdemo.model.Product;
import com.jwtapp.jwtappdemo.repository.ProductRepositoryInterf;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepositoryInterf productRepository;
//get All products
    public List<Product> getAll() {
        return productRepository.findAll();
    }
// get by id
    public Product getById(long id) {
        return productRepository.findById(id).orElse(null);
    }
//save product
    public Product save(Product product) {
        return productRepository.save(product);
    }
    // delete product
    public void delete(Product product) {
        productRepository.delete(product);
    }
}
