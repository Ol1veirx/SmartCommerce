package com.github_ol1veirx.smartcommerce.DTO;

import com.github_ol1veirx.smartcommerce.Entities.Product;
import jakarta.validation.constraints.*;

public class ProductDTO {
    private Long id;

    @Size(min = 2, max = 80, message = "Min value in field is 2 and max 80")
    @NotBlank(message = "Required field")
    private String name;

    @Size(min = 10, message = "Min value in field is 10 characters")
    @NotBlank(message = "Required field")
    private String description;

    @Positive(message = "Price required positive")
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
