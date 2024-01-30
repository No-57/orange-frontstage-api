package com.orange.main.products.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.orange.main.products.bo.ProductDTO;
import com.orange.main.products.bo.ProductLike;
import com.orange.main.products.bo.Products;

public interface ProductsService {
    Products getProductById(Long productId);

    Iterable<ProductDTO> getAllProducts(Pageable page, List<String> fields);

    Iterable<ProductDTO> findByNameIn(Pageable page, List<String> name, List<String> fields);

    String getProductsImgs(Long productId);

    void saveProductLikes(Long productId, Long userId);

    void updateProductLikes(Long productId, Long userId, Boolean liked);

    ProductLike getProductLikes(Long productId, Long userId);
}
