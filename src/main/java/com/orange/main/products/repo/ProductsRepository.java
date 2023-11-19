package com.orange.main.products.repo;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.orange.main.products.bo.Products;

public interface ProductsRepository extends JpaRepository<Products, Long>{
    /* Repository will automatially generate sql according to method name */
    public Iterable<Products> findByNameIn(List<String> names, Sort sort);
}
