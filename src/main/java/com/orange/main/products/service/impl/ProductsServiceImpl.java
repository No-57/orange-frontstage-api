package com.orange.main.products.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.orange.main.products.bo.Products;
import com.orange.main.products.repo.ProductsRepository;
import com.orange.main.products.service.ProductsService;

import io.micrometer.common.util.StringUtils;
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
        Optional<Products> optionalUser =  productsRepository.findById(productId);
        return optionalUser.get();
    }

    @Override
    public Iterable<Products> getAllProducts() {
        return productsRepository.findAll();
    }

    @Override
    public Iterable<Products> findByNameIn(List<String> name, String sortBy, String orderBy) {
        return productsRepository.findByNameIn(name,Sort.by("DESC".equals(orderBy)?Sort.Direction.DESC:Sort.Direction.ASC, StringUtils.isNotBlank(sortBy)?sortBy:"id"));
    }


    public ProductsRepository getProductsRepository() {
        return this.productsRepository;
    }

    public void setProductsRepository(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }
}
