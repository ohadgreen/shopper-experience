package com.niq.shoppers_data.persistance.repositories;

import com.niq.shoppers_data.model.input.SaveEntitiesResult;
import com.niq.shoppers_data.model.input.ShopperToProduct;

import java.util.List;

public interface ShopperToProductRepository {
    SaveEntitiesResult saveOrUpdateShopperToProductList(List<ShopperToProduct> shopperToProductList);
}
