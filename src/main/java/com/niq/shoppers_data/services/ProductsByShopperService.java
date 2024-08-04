package com.niq.shoppers_data.services;

import com.niq.shoppers_data.model.ProductByShopper;

import java.util.List;

public interface ProductsByShopperService {
    List<ProductByShopper> getProductsByShopper(String shopperId, String category, String brand, Integer limit);
}
