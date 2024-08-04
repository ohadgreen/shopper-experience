package com.niq.shoppers_data.services;

import com.niq.shoppers_data.model.ShopperShelf;

import java.util.List;

public interface ShopperToProductDataService {
    void saveShopperProductsData(List<ShopperShelf> shopperShelfList);
}
