package com.example.productserviceaug25.controllers;

import com.example.productserviceaug25.Exceptions.ProductNotFoundException;
import com.example.productserviceaug25.Models.Product;
import com.example.productserviceaug25.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {


    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{productId}")
    public Product getSingleProduct(@PathVariable Long productId) throws ProductNotFoundException {

        return productService.getSingleProduct(productId);
    }

    @GetMapping()
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping()
    public Product createProduct(@RequestBody Product product) {

        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long productId, @RequestBody Product product ) {

        return productService.replaceProduct(productId, product);
    }

    @DeleteMapping()
    public void deleteProduct(@RequestBody Product product) {
        productService.deleteProduct(product.getId());
    }


    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handleProductNotFoundException() {

        return new ResponseEntity<>(
                "Product Not Found. Please Try Again",
                HttpStatus.NOT_FOUND);
    }
}
