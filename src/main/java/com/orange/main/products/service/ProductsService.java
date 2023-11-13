package com.orange.main.products.service;



import java.util.List;

import com.orange.main.products.bo.Products;

public interface ProductsService {
    Products getProductById(Long productId);

    Iterable<Products> getAllProducts();

    Iterable<Products> findByNameIn(List<String> name,String sortBy, String orderBy);
}
