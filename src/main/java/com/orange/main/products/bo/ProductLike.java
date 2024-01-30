package com.orange.main.products.bo;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "product_like")
public class ProductLike {
    @EmbeddedId
    private ProductLikeKey productLikeKey;
    private boolean likes;

    public ProductLike() {

    }

    public ProductLike(ProductLikeKey productLikeKey) {
        this.productLikeKey = productLikeKey;
    }

    public boolean isLikes() {
        return likes;
    }

    public void setLikes(boolean likes) {
        this.likes = likes;
    }

    public ProductLikeKey getProductLikeKey() {
        return productLikeKey;
    }

    public void setProductLikeKey(ProductLikeKey productLikeKey) {
        this.productLikeKey = productLikeKey;
    }
}
