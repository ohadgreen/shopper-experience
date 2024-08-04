package com.niq.shoppers_data.model.input;

import java.io.Serializable;

public class ProductRelevancyToShopper implements Serializable {
    private String productId;
    private Double relevancyScore;

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
}
