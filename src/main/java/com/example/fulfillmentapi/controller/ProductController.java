package com.example.fulfillmentapi.controller;

import com.example.fulfillmentapi.model.Product;
import com.example.fulfillmentapi.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @GetMapping("/filter")
    public List<Product> filterByStatus(@RequestParam String status) {
        return productService.filterByStatus(status);
    }

    @GetMapping("/total-value/sellable")
    public double getTotalValueOfSellable() {
        return productService.calculateTotalValueOfSellable();
    }
}