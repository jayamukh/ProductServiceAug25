package com.example.productserviceaug25.Service;

import com.example.productserviceaug25.Models.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {
    List<Product> getAllProducts();
    Product getSingleProduct(Long id);
    Product createProduct(Product product);
    Product replaceProduct(Long id, Product product);
    void deleteProduct(Long id);
}
