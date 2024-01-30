package com.orange.main.products.bo;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ProductLikeKey implements Serializable {
    @Column(name = "product_id", nullable = false)
    private Long productId;
    @Column(name = "user_id", nullable = false)
    private Long userId;

    public ProductLikeKey() {

    }

    public ProductLikeKey(Long productId, Long userId) {
        this.productId = productId;
        this.userId = userId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}
