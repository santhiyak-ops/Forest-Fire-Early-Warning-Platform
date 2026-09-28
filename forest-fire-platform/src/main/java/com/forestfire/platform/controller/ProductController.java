package com.forestfire.platform.controller;

import com.forestfire.platform.entity.Product;
import com.forestfire.platform.service.ProductService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/forest/products")
public class ProductController {
    private final ProductService service;
    public ProductController(ProductService service) { this.service = service; }

    @PostMapping
    public Product create(@RequestBody Product item) { return service.create(item); }

    @GetMapping
    public List<Product> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) { return service.getById(id); }
}
