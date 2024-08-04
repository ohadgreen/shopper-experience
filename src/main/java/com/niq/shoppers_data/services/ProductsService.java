package com.niq.shoppers_data.services;

import com.niq.shoppers_data.model.Product;

import java.util.List;
import java.util.Set;

public interface ProductsService {
    void saveProductList(List<Product> productList);
    Set<String> getAllCategories();
    Set<String> getAllBrands();
    Set<String> getAllProductIds();
}
