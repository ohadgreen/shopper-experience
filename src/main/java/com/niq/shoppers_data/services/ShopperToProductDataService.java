package com.niq.shoppers_data.services;

import com.niq.shoppers_data.model.input.SaveEntitiesResult;
import com.niq.shoppers_data.model.input.ShopperShelf;

import java.util.List;

public interface ShopperToProductDataService {
    SaveEntitiesResult saveShopperProductsData(List<ShopperShelf> shopperShelfList);
}
