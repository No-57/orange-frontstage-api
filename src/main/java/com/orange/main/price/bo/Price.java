package com.orange.main.price.bo;

import java.math.BigDecimal;
import java.util.TimeZone;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "price")
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int productId;
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }



    private BigDecimal price;
    private BigDecimal discount;
    private String source_url;
    @Enumerated(EnumType.STRING)
    @Column(name = "seller_type")
    private SellerSource sellerType;
    private TimeZone updated_date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public String getSource_url() {
        return source_url;
    }

    public void setSource_url(String source_url) {
        this.source_url = source_url;
    }

    public TimeZone getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(TimeZone updated_date) {
        this.updated_date = updated_date;
    }

    public SellerSource getSellerType() {
        return sellerType;
    }

    public void setSellerType(SellerSource sellerType) {
        this.sellerType = sellerType;
    }

    public enum SellerSource{
        OTHER, YAHOO, AMAZON, SHOPEE, MOMO, PCHOME
    }
}
