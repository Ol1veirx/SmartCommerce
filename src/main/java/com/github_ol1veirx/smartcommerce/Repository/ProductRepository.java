package com.github_ol1veirx.smartcommerce.Repository;

import com.github_ol1veirx.smartcommerce.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
