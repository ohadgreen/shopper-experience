package com.niq.shoppers_data.services;

import com.niq.shoppers_data.model.input.Product;
import com.niq.shoppers_data.model.input.SaveEntitiesResult;
import com.niq.shoppers_data.persistance.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ProductsServiceImpl implements ProductsService {
    private final ProductRepository productRepository;

    public ProductsServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public SaveEntitiesResult saveProductList(List<Product> productList) {
        return productRepository.saveOrUpdateProducts(productList);
    }

    @Override
    public Set<String> getAllCategories() {
        return productRepository.getAllCategories();
    }

    @Override
    public Set<String> getAllBrands() {
        return productRepository.getAllBrands();
    }

    @Override
    public Set<String> getAllProductIds() {
        return productRepository.getAllProductIds();
    }

}
