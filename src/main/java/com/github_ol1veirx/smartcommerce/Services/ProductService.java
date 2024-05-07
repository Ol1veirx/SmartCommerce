package com.github_ol1veirx.smartcommerce.Services;

import com.github_ol1veirx.smartcommerce.DTO.ProductDTO;
import com.github_ol1veirx.smartcommerce.Entities.Product;
import com.github_ol1veirx.smartcommerce.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        Product product = productRepository.findById(id).get();
        return new ProductDTO(product);
    }
}
