package com.sliit.product_service.controller;

import com.sliit.product_service.model.Product;
import com.sliit.product_service.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductRepository repository;

    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    // POST - Create Product
    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return repository.save(product);
    }

    // GET - Get All Products
    @GetMapping
    public List<Product> getAllProducts(){
        return repository.findAll();
    }

    // GET - Get Product by ID
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        return repository.findById(id).orElse(null);
    }

    //DELETE - Delete Product by ID
    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id){
        repository.deleteById(id);
    }


}
