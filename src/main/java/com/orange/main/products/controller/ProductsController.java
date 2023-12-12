package com.orange.main.products.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orange.main.BaseController;
import com.orange.main.products.bo.Products;
import com.orange.main.products.service.ProductsService;
import com.orange.main.utility.ApiChecker;

import io.micrometer.common.util.StringUtils;

@RestController
public class ProductsController  extends BaseController{
    
    @Autowired
    private ProductsService productsService;

    @GetMapping("/products")
    public Object getProducts(@RequestParam(required = false, defaultValue = "1") int page, 
    @RequestParam(required = false, defaultValue = "10") int page_size, 
    @RequestParam(required = false) List<String> name, 
    @RequestParam(required = false, defaultValue = "id") String sort_by, 
    @RequestParam(required = false, defaultValue = "ASC") String order_by, 
    @RequestParam(required = false) List<String> fields) {
        Sort s = Sort.by(Direction.fromString(order_by),sort_by);
        if(StringUtils.isNotBlank(ApiChecker.PageableChecker(page,page_size))){
            return checkError("9999",ApiChecker.PageableChecker(page,page_size),"");
        }
        PageRequest p = PageRequest.of(page-1, page_size, s);
        Iterable<Products> product;
        if(CollectionUtils.isEmpty(name))
            product = productsService.getAllProducts(p, fields);
        else
            product = productsService.findByNameIn(p, name, fields);

        return transResponseObj(product);
    }

    @GetMapping("/products/{id}")
    public Object getProductsById(Pageable page, 
    @PathVariable(name = "id", required = true) Long id) {
        Products product = productsService.getProductById(id);
        
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
