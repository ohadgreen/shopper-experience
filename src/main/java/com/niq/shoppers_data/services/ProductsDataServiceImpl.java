package com.niq.shoppers_data.services;

import com.niq.shoppers_data.model.Product;
import com.niq.shoppers_data.persistance.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsDataServiceImpl implements ProductsService {
    private final ProductRepository productRepository;

    public ProductsDataServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void saveProductList(List<Product> productList) {
        productRepository.saveOrUpdateProducts(productList);
    }

}
