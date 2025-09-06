package com.wiproo.product.service;
import com.wiproo.product.entity.*;
import com.wiproo.product.repository.*;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class ProductService {


private final ProductRepository repository;


public ProductService(ProductRepository repository) {
this.repository = repository;
}


public Product save(Product product) {
return repository.save(product);
}


public List<Product> findAll() {
return repository.findAll();
}


public Optional<Product> findById(Integer id) {
return repository.findById(id);
}


public Product update(Integer id, Product updated) {
return repository.findById(id)
.map(existing -> {
existing.setProductName(updated.getProductName());
existing.setProductMake(updated.getProductMake());
existing.setProductPrice(updated.getProductPrice());
return repository.save(existing);
})
.orElseThrow(() -> new RuntimeException("Product not found with id " + id));
}


public void deleteById(Integer id) {
repository.deleteById(id);
}
}