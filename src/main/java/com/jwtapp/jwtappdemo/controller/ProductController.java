package com.jwtapp.jwtappdemo.controller;

import com.jwtapp.jwtappdemo.model.Product;
import com.jwtapp.jwtappdemo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    @GetMapping("/all")
    public ResponseEntity< ?> getProduct() {

        return ResponseEntity.ok().body(productService.getAll());
    }
}
