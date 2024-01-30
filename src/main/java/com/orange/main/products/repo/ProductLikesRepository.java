package com.orange.main.products.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orange.main.products.bo.ProductLike;
import com.orange.main.products.bo.ProductLikeKey;

public interface ProductLikesRepository extends JpaRepository<ProductLike, Long> {
    ProductLike save(ProductLike s);

    ProductLike findByProductLikeKey(ProductLikeKey k);
}
