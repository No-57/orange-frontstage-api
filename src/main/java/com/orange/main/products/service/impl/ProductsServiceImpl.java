package com.orange.main.products.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.orange.main.price.bo.Price;
import com.orange.main.products.bo.ProductDTO;
import com.orange.main.products.bo.ProductImgs;
import com.orange.main.products.bo.ProductLike;
import com.orange.main.products.bo.ProductLikeKey;
import com.orange.main.products.bo.Products;
import com.orange.main.products.repo.ProductImgsRepository;
import com.orange.main.products.repo.ProductLikesRepository;
import com.orange.main.products.repo.ProductsRepository;
import com.orange.main.products.service.ProductsService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private ProductImgsRepository productImgsRepository;

    @Autowired
    private ProductLikesRepository productLikesRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Products getProductById(Long productId) {
        Optional<Products> product = productsRepository.findById(productId);
        return product.get();
    }

    @Override
    public List<ProductDTO> getAllProducts(Pageable page, List<String> fields) {
        List<ProductDTO> dto = new ArrayList<>();
        Page<Products> products = productsRepository.findAll(page);
        // fields filiter
        List<Products> rtn = products.getContent().stream().map(p -> handleUnspecifiedColumns(p, fields)).toList();

        if (!CollectionUtils.isEmpty(rtn)) {
            for (Products product : rtn) {
                Price p = product.getPrices()
                        .stream()
                        .min(Comparator.comparing(Price::getPrice))
                        .orElseThrow(NoSuchElementException::new);
                ProductDTO productDto = new ProductDTO(product, p.getSellerType().toString(), p.getPrice(),
                        p.getDiscount(), null == product.getProductImgs() ? null : product.getProductImgs().getPath());
                dto.add(productDto);
            }
        }
        return dto;
    }

    @Override
    public List<ProductDTO> findByNameIn(Pageable page, List<String> name, List<String> fields) {
        List<ProductDTO> dto = new ArrayList<>();
        Page<Products> products = productsRepository.findByNameIn(page, name);
        // fields filiter
        List<Products> rtn = products.getContent().stream().map(p -> handleUnspecifiedColumns(p, fields)).toList();
        if (CollectionUtils.isEmpty(rtn)) {
            return dto;
        }

        for (Products product : rtn) {
            Price p = product.getPrices()
                    .stream()
                    .min(Comparator.comparing(Price::getPrice))
                    .orElseThrow(NoSuchElementException::new);
            ProductDTO productDto = new ProductDTO(product, p.getSellerType().toString(), p.getPrice(), p.getDiscount(),
                    getImgsUrl(product.getId()));
            productDto.getProducts().setPrices(null);
            dto.add(productDto);
        }
        return dto;
    }

    private String getImgsUrl(Long id) {
        return "http://localhost:8080/api/v1/products/" + id + "/imgs";
    }

    public ProductsRepository getProductsRepository() {
        return this.productsRepository;
    }

    public void setProductsRepository(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    // fields filiter
    public Products handleUnspecifiedColumns(Products p, List<String> specifiedColumns) {
        if (!CollectionUtils.isEmpty(specifiedColumns)) {
            if (!specifiedColumns.contains("id"))
                p.setId(null);
            if (!specifiedColumns.contains("name"))
                p.setName(null);
            if (!specifiedColumns.contains("description"))
                p.setDescription(null);
            if (!specifiedColumns.contains("types"))
                p.setTypes(null);
            if (!specifiedColumns.contains("createdDate"))
                p.setCreatedDate(null);
            if (!specifiedColumns.contains("updatedDate"))
                p.setUpdatedDate(null);
        }
        return p;
    }

    @Override
    public String getProductsImgs(Long productId) {
        Optional<ProductImgs> imgs = productImgsRepository.findById(productId);
        if (imgs.isPresent())
            return imgs.get().getPath();
        else
            return null;

    }

    @Override
    public ProductLike getProductLikes(Long productId, Long userId) {
        ProductLike productLike = productLikesRepository.findByProductLikeKey(new ProductLikeKey(productId, userId));

        return productLike;
    }

    @Override
    public void saveProductLikes(Long productId, Long userId) {
        ProductLike productLike = new ProductLike(new ProductLikeKey(productId, userId));
        productLike.setLikes(true);

        productLikesRepository.save(productLike);
    }

    @Override
    public void updateProductLikes(Long productId, Long userId, Boolean liked) {
        ProductLike productLike = productLikesRepository.findByProductLikeKey(new ProductLikeKey(productId, userId));
        productLike.setLikes(liked);

        productLikesRepository.save(productLike);
    }
}
