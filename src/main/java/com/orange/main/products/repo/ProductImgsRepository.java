package com.orange.main.products.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orange.main.products.bo.ProductImgs;

public interface ProductImgsRepository extends JpaRepository<ProductImgs, Long> {
    public Optional<ProductImgs> findById(Long id);
}
