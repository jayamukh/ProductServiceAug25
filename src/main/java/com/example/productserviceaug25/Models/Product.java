package com.example.productserviceaug25.Models;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Product extends BaseModel{

private String title;
private String description;
private Double price;
private String imageUrl;
private Category category;
}
