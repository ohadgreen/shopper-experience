package com.niq.shoppers_data.persistance.repositories;

import com.niq.shoppers_data.model.Product;

import java.util.List;
import java.util.Set;

public interface ProductRepository {

    void saveOrUpdateProducts(List<Product> productList);
    Set<String> getAllCategories();
    Set<String> getAllBrands();
    Set<String> getAllProductIds();

}
