package com.example.productserviceaug25.Service;

import com.example.productserviceaug25.DTOs.FakeStoreProductDto;
import com.example.productserviceaug25.Models.Category;
import com.example.productserviceaug25.Models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreProductService implements ProductService {

    private final RestTemplate restTemplate;

    @Autowired
    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product getSingleProduct(Long id) {

        ResponseEntity<FakeStoreProductDto> responseEntity =
                restTemplate.getForEntity("https://fakestoreapi.com/products/1" + id, FakeStoreProductDto.class);


        return convertToProductDTO(responseEntity.getBody());
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {

    }

    private Product convertToProductDTO( FakeStoreProductDto dto )
    {
        if(dto != null) {
            Product product = new Product();
            product.setId(dto.getId());
            product.setTitle(dto.getTitle());
            product.setDescription(dto.getDescription());
            product.setPrice(dto.getPrice());
            product.setImageUrl(dto.getImage());

            Category category = new Category();
            category.setTitle(dto.getCategory());
            product.setCategory(category);
            return product;
        }
        return null;
    }
}
