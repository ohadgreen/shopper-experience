package com.niq.shoppers_data.persistance.repositories;

import com.niq.shoppers_data.model.ShopperToProduct;
import com.niq.shoppers_data.persistance.mappers.ShopperToProductMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    public void saveOrUpdateShopperToProductList(List<ShopperToProduct> shopperToProductList) {
        String sql = "INSERT INTO shopper_to_product (shopperId, productId, relevancyScore, created, modified) VALUES (?, ?, ?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP) " +
                "ON DUPLICATE KEY UPDATE relevancyScore = VALUES(relevancyScore), modified = CURRENT_TIMESTAMP";

        jdbcTemplate.batchUpdate(sql, shopperToProductList, shopperToProductList.size(),
                (ps, shopperToProduct) -> {
                    ps.setString(1, shopperToProduct.getShopperId());
                    ps.setString(2, shopperToProduct.getProductId());
                    ps.setDouble(3, shopperToProduct.getRelevancyScore());
                });
    }

}
