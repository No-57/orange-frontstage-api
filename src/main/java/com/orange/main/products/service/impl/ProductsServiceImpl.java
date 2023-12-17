package com.orange.main.products.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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
        Optional<Products> product = productsRepository.findById(productId);
        return product.get();
    }

    @Override
    public List<Products> getAllProducts(Pageable page, List<String> fields) {
        Page<Products> products = productsRepository.findAll(page);
        //fields filiter
        List<Products> rtn = products.getContent().stream().map(p -> handleUnspecifiedColumns(p, fields)).toList();
        return rtn;
    }

    @Override
    public List<Products> findByNameIn(Pageable page, List<String> name, List<String> fields) {
        Page<Products> products = productsRepository.findByNameIn(page, name);
        //fields filiter
        List<Products> rtn = products.getContent().stream().map(p -> handleUnspecifiedColumns(p, fields)).toList();
        return rtn;
    }

    public ProductsRepository getProductsRepository() {
        return this.productsRepository;
    }

    public void setProductsRepository(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    //fields filiter
    public Products handleUnspecifiedColumns(Products p, List<String> specifiedColumns) {
        if(!CollectionUtils.isEmpty(specifiedColumns)){
            if(!specifiedColumns.contains("id")) p.setId(null);
            if(!specifiedColumns.contains("name")) p.setName(null);
            if(!specifiedColumns.contains("description")) p.setDescription(null);
            if(!specifiedColumns.contains("types")) p.setTypes(null);
            if(!specifiedColumns.contains("createdDate")) p.setCreatedDate(null);
            if(!specifiedColumns.contains("updatedDate")) p.setUpdatedDate(null);
        }
        return p;
    }
}
