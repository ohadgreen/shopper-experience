package com.niq.shoppers_data.persistance.repositories;

import com.niq.shoppers_data.model.ShopperToProduct;

import java.util.List;

public interface ShopperToProductRepository {
    void saveShopperToProduct(ShopperToProduct shopperToProduct);
    void saveOrUpdateShopperToProductList(List<ShopperToProduct> shopperToProductList);
}
