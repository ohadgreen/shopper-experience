package com.niq.shoppers_data.model;

import org.springframework.data.annotation.Transient;

import java.time.LocalDateTime;

public class ShopperToProduct {
    private String shopperId;
    private String productId;
    private Double relevancyScore;
    @Transient
    private LocalDateTime created;
    @Transient
    private LocalDateTime modified;

    public String getShopperId() {
        return shopperId;
    }

    public void setShopperId(String shopperId) {
        this.shopperId = shopperId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Double getRelevancyScore() {
        return relevancyScore;
    }

    public void setRelevancyScore(Double relevancyScore) {
        this.relevancyScore = relevancyScore;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

}
