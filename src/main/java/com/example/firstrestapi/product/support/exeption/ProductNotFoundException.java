package com.example.firstrestapi.product.support.exeption;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(Long id) {
        super(String.format("Product with %d not found", id));
    }
}
