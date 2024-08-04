package com.niq.shoppers_data.services;

import com.niq.shoppers_data.model.input.Product;
import com.niq.shoppers_data.model.input.SaveEntitiesResult;

import java.util.List;
import java.util.Set;

public interface ProductsService {
    SaveEntitiesResult saveProductList(List<Product> productList);
    Set<String> getAllCategories();
    Set<String> getAllBrands();
    Set<String> getAllProductIds();
}
