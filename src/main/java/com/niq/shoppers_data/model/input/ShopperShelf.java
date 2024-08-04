package com.niq.shoppers_data.model.input;

import java.util.List;

public class ShopperShelf {
    private String shopperId;
    private List<ProductRelevancyToShopper> shelf;

    public String getShopperId() {
        return shopperId;
    }

    public void setShopperId(String shopperId) {
        this.shopperId = shopperId;
    }

    public List<ProductRelevancyToShopper> getShelf() {
        return shelf;
    }

    public void setShelf(List<ProductRelevancyToShopper> shelf) {
        this.shelf = shelf;
    }
}
