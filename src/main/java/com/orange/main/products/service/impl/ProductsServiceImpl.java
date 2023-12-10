package com.orange.main.products.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.orange.main.products.bo.Products;
import com.orange.main.products.repo.ProductsRepository;
import com.orange.main.products.service.ProductsService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    private ProductsRepository productsRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Products getProductById(Long productId) {
        Optional<Products> product =  productsRepository.findById(productId);
        return product.get();
    }

    @Override
    public Iterable<Products> getAllProducts(Pageable page, List<String> fields) {
        Page<Products> products = productsRepository.findAll(page);
        //TODO fields filiter
        return products.getContent();
    }

    @Override
    public Iterable<Products> findByNameIn(Pageable page, List<String> name, List<String> fields) {
        Iterable<Products> products = productsRepository.findByNameIn(page, name);
        //TODO fields filiter
        return products;
    }

    //TODO fields filiter


    public ProductsRepository getProductsRepository() {
        return this.productsRepository;
    }

    public void setProductsRepository(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }
}
