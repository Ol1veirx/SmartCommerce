package com.github_ol1veirx.smartcommerce.DTO;

import com.github_ol1veirx.smartcommerce.Entities.Product;
import jakarta.persistence.Column;

public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String imageUrl;

    private ProductDTO() {}

    //Conversão de uma entidade para DTO
    public ProductDTO(Product entity) {
        id = entity.getId();
        name = entity.getName();
        description = entity.getDescription();
        price = entity.getPrice();
        imageUrl = entity.getImageUrl();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
