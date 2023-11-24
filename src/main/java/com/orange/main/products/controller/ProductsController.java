package com.orange.main.products.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orange.main.BaseController;
import com.orange.main.products.bo.Products;
import com.orange.main.products.service.ProductsService;

@RestController
public class ProductsController  extends BaseController{
    
    @Autowired
    private ProductsService productsService;

    @GetMapping("/products/all")
    public Object getProducts() {
        Iterable<Products> product = productsService.getAllProducts();
        Collection<Products> rt = new ArrayList<>();
        product.forEach(rt::add);

        return transResponseObj(rt);
    }

    @GetMapping("/products")
    public Object getProducts(@RequestParam(name = "name", required = false) List<String> name, @RequestParam(name = "sort_by", required = false) String sortBy, @RequestParam(name = "order_by", required = false) String orderBy) {
        Iterable<Products> product = productsService.findByNameIn(name, sortBy, orderBy!=null?orderBy.toUpperCase():"ASC");
        
        return transResponseObj(product);
    }

    @GetMapping("/health")
    public Object getHealth() {
        return transResponseObj("Egg");
    }

    public ProductsService getProductsService() {
        return this.productsService;
    }

    public void setProductsService(ProductsService productsService) {
        this.productsService = productsService;
    }
}
