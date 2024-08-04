package com.niq.shoppers_data.services;

import com.niq.shoppers_data.model.ProductByShopper;
import com.niq.shoppers_data.persistance.repositories.ProductsByShopperRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsByShopperServiceImpl implements ProductsByShopperService{
    private final ProductsByShopperRepository productsByShopperRepository;

    public ProductsByShopperServiceImpl(ProductsByShopperRepository productsByShopperRepository) {
        this.productsByShopperRepository = productsByShopperRepository;
    }

    @Override
    public List<ProductByShopper> getProductsByShopper(String shopperId, String category, String brand, Integer limit) {
        return productsByShopperRepository.getProductsByShopper(shopperId, category, brand, limit);
    }
}
