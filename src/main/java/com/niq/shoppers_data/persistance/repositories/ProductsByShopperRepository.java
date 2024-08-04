package com.niq.shoppers_data.persistance.repositories;

import com.niq.shoppers_data.model.output.ProductByShopper;

import java.util.List;

public interface ProductsByShopperRepository {
    List<ProductByShopper> getProductsByShopper(String shopperId, String category, String brand, Integer limit);
}
