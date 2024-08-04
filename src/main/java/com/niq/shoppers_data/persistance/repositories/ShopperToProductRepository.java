package com.niq.shoppers_data.persistance.repositories;

import com.niq.shoppers_data.model.ShopperToProduct;

public interface ShopperToProductRepository {
    void saveShopperToProduct(ShopperToProduct shopperToProduct);

    ShopperToProduct getShopperToProduct(String shopperId, String productId);
}
