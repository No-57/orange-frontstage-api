package com.orange.main.products.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.orange.main.products.bo.Products;

public interface ProductsService {
    Products getProductById(Long productId);

    Iterable<Products> getAllProducts(Pageable page, List<String> fields);

    Iterable<Products> findByNameIn(Pageable page, List<String> name, List<String> fields);
}
