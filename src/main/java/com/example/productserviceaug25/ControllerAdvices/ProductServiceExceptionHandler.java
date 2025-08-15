package com.example.productserviceaug25.ControllerAdvices;

import com.example.productserviceaug25.Exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductServiceExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Void> handleRuntimeException() {
       // return ResponseEntity.badRequest().build();
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handleNullPointerException() {
        // return ResponseEntity.badRequest().build();
        return new ResponseEntity<>(
                "Please try again with a valid Product ID",
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handleProductNotFoundException(ProductNotFoundException ex) {
        // return ResponseEntity.badRequest().build();
        return new ResponseEntity<>(
                ex.getProductId() + " is an invalid Product ID. Please pass a valid Product ID. ",
                HttpStatus.NOT_FOUND);
    }
}
