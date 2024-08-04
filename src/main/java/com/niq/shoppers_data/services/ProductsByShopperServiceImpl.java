package com.niq.shoppers_data.services;

import com.niq.shoppers_data.model.ProductByShopper;
import com.niq.shoppers_data.persistance.repositories.ProductsByShopperRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class ProductsByShopperServiceImpl implements ProductsByShopperService{
    private final ProductsByShopperRepository productsByShopperRepository;
    private final Logger logger = Logger.getLogger(ProductsByShopperServiceImpl.class.getName());

    public ProductsByShopperServiceImpl(ProductsByShopperRepository productsByShopperRepository) {
        this.productsByShopperRepository = productsByShopperRepository;
    }

    @Override
//    @Cacheable(value = "shopperProductsCache", key = "'shopperId-' + #shopperId")
    public List<ProductByShopper> getProductsByShopper(String shopperId, String category, String brand, Integer limit) {
        logger.info("Fetching products for shopperId: " + shopperId + ", category: " + category + ", brand: " + brand + ", limit: " + limit);
        return productsByShopperRepository.getProductsByShopper(shopperId, category, brand, limit);
    }
}
