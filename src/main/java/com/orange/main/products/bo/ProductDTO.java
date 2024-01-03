package com.orange.main.products.bo;

import java.math.BigDecimal;


public class ProductDTO {

    public ProductDTO(Products products, String distributor, BigDecimal price, BigDecimal discount, String path){
        this.products = products;
        if(null != this.products.getPrices()){
            this.products.setPrices(null);
        }
        this.distributor = distributor;
        this.price = price;
        this.discount = discount;
        this.path = path;
    }

    private Products products;
    private String distributor;
    private BigDecimal price;
    private BigDecimal discount;
    private String path;

     public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public String getDistributor() {
        return this.distributor;
    }

    public void setDistributor(String distributor) {
        this.distributor = distributor;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getDiscount() {
        return this.discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

   
/* 
    public List<Price> getPrices() {
        return this.prices;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
    }
*/
}
