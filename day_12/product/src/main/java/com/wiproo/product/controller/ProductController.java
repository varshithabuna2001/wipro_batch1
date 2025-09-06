package com.wiproo.product.controller;
import com.wiproo.product.service.*;
import com.wiproo.product.entity.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api/products")
public class ProductController {


@Autowired
ProductService productService;


public ProductController(ProductService productService) {
this.productService = productService;
}


@PostMapping
public ResponseEntity<Product> createProduct(@RequestBody Product product) {
Product saved = productService.save(product);
return new ResponseEntity<>(saved, HttpStatus.CREATED);
}


@GetMapping
public ResponseEntity<List<Product>> getAllProducts() {
return ResponseEntity.ok(productService.findAll());
}


@GetMapping("/{id}")
public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
return productService.findById(id)
.map(ResponseEntity::ok)
.orElse(ResponseEntity.notFound().build());
}


@PutMapping("/{id}")
public ResponseEntity<Product> updateProduct(@PathVariable Integer id, @RequestBody Product product) {
try {
Product updated = productService.update(id, product);
return ResponseEntity.ok(updated);
} catch (RuntimeException e) {
return ResponseEntity.notFound().build();
}
}


@DeleteMapping("/{id}")
public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
productService.deleteById(id);
return ResponseEntity.noContent().build();
}
}