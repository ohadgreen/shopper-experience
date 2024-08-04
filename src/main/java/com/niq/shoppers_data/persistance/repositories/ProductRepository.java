package com.niq.shoppers_data.persistance.repositories;

import com.niq.shoppers_data.model.input.Product;
import com.niq.shoppers_data.model.input.SaveEntitiesResult;

import java.util.List;
import java.util.Set;

public interface ProductRepository {

    SaveEntitiesResult saveOrUpdateProducts(List<Product> productList);
    Set<String> getAllCategories();
    Set<String> getAllBrands();
    Set<String> getAllProductIds();

}
