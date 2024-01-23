package com.orange.main.products.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.orange.main.products.bo.Products;

public interface ProductsRepository extends PagingAndSortingRepository<Products, Long> {
    /* Repository will automatially generate sql according to method name */
    public Page<Products> findByNameIn(Pageable page, List<String> name);

    public Optional<Products> findById(Long id);
}
