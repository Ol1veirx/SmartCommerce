package com.github_ol1veirx.smartcommerce.Services;

import com.github_ol1veirx.smartcommerce.DTO.ProductDTO;
import com.github_ol1veirx.smartcommerce.Entities.Product;
import com.github_ol1veirx.smartcommerce.Repository.ProductRepository;
import com.github_ol1veirx.smartcommerce.Services.Exceptions.DatabaseException;
import com.github_ol1veirx.smartcommerce.Services.Exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.lang.module.ResolutionException;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Product Not Found"));
        return new ProductDTO(product);
    }

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll(String name, Pageable pageable) {
        Page<Product> product = productRepository.searchProductByName(name, pageable);
        return product.map(x -> new ProductDTO(x));
    }

    // Readonly não foi usado porque altera no banco de dados
    @Transactional
    public ProductDTO create(ProductDTO productDTO) {
        Product entity = new Product();
        copyDtoToEntity(productDTO, entity);
        productRepository.save(entity);
        return new ProductDTO(entity);
    }

    @Transactional
    public ProductDTO update(Long id, ProductDTO productDTO) {
        try {
            Product entity = productRepository.getReferenceById(id);
            copyDtoToEntity(productDTO, entity);
            entity = productRepository.save(entity);
            return new ProductDTO(entity);
        }
        catch(EntityNotFoundException e) {
            throw new ResourceNotFoundException("Product Not Found");
        }

    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if(!productRepository.existsById(id)){
            throw new ResourceNotFoundException("Product Not Found");
        }
        try {
            productRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Product Not Found");
        }
        catch(DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity Violation");
        }
    }

    private ProductDTO copyDtoToEntity(ProductDTO productDTO, Product entity) {
        entity.setName(productDTO.getName());
        entity.setDescription(productDTO.getDescription());
        entity.setPrice(productDTO.getPrice());
        entity.setImageUrl(productDTO.getImageUrl());
        return new ProductDTO(entity);
    }
}
