package com.jwtapp.jwtappdemo.controller;

import com.jwtapp.jwtappdemo.model.Product;
import com.jwtapp.jwtappdemo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    @GetMapping("/all")
    public ResponseEntity< ?> getProduct() {
        return ResponseEntity.ok().body(productService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity< ?> getProductById(@PathVariable long id) {
        return ResponseEntity.ok().body(productService.getById(id));

    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping
    public void deleteProduct(@RequestBody Product product) {
        productService.delete(product);
    }
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> saveProduct(@RequestBody Product product) {
        return ResponseEntity.ok().body(productService.save(product));
    }

    @PreAuthorize("hasRole('ADIMIN')")
    @PutMapping("/update")
public ResponseEntity<?> updateProduct(@RequestBody Product product) {
        return ResponseEntity.ok().body(productService.save(product));
}
}
