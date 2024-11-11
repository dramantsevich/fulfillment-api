package com.example.fulfillmentapi.service;

import com.example.fulfillmentapi.exception.ResourceNotFoundException;
import com.example.fulfillmentapi.model.Product;
import com.example.fulfillmentapi.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product productDetails) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        product.setStatus(productDetails.getStatus());
        product.setFulfillmentCenter(productDetails.getFulfillmentCenter());
        product.setQuantity(productDetails.getQuantity());
        product.setValue(productDetails.getValue());
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> filterByStatus(String status) {
        return productRepository.findByStatus(status);
    }

    public double calculateTotalValueOfSellable() {
        return productRepository.findByStatus("Sellable")
                .stream()
                .mapToDouble(product -> product.getValue().doubleValue())
                .sum();
    }
}
