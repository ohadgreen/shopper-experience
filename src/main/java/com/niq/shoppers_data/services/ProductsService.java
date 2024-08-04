package com.niq.shoppers_data.services;

import com.niq.shoppers_data.model.Product;

import java.util.List;

public interface ProductsService {
    void saveProductList(List<Product> productList);
}
