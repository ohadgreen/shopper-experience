package com.niq.shoppers_data.persistance.repositories;

import com.niq.shoppers_data.model.ShopperToProduct;
import com.niq.shoppers_data.persistance.mappers.ShopperToProductMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ShopperToProductRepositoryImpl implements ShopperToProductRepository {

    private final JdbcTemplate jdbcTemplate;
    private final ShopperToProductMapper shopperToProductMapper;

    public ShopperToProductRepositoryImpl(JdbcTemplate jdbcTemplate, ShopperToProductMapper shopperToProductMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.shopperToProductMapper = shopperToProductMapper;
    }

    @Override
    public void saveShopperToProduct(ShopperToProduct shopperToProduct) {
        jdbcTemplate.update("INSERT INTO shopper_to_product (shopperId, productId, relevancyScore) VALUES (?, ?, ?)",
                shopperToProduct.getShopperId(), shopperToProduct.getProductId(), shopperToProduct.getRelevancyScore());
    }

    @Override
    public ShopperToProduct getShopperToProduct(String shopperId, String productId) {
        return jdbcTemplate.queryForObject("SELECT * FROM shopper_to_product WHERE shopperId = ? AND productId = ?",
                shopperToProductMapper, shopperId, productId);
    }
}
