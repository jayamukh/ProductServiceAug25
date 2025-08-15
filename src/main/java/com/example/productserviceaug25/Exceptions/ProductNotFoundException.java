package com.example.productserviceaug25.Exceptions;

public class ProductNotFoundException extends Exception {
    private Long productId;
    public ProductNotFoundException(Long productId) {
        this.productId = productId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
