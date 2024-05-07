package com.github_ol1veirx.smartcommerce.Controllers;

import com.github_ol1veirx.smartcommerce.DTO.ProductDTO;
import com.github_ol1veirx.smartcommerce.Entities.Product;
import com.github_ol1veirx.smartcommerce.Repository.ProductRepository;
import com.github_ol1veirx.smartcommerce.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public ProductDTO findById(@PathVariable long id) {
        return productService.findById(id);
    }
}
