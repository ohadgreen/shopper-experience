package com.niq.shoppers_data.persistance.repositories;

import com.niq.shoppers_data.model.input.SaveEntitiesResult;
import com.niq.shoppers_data.model.input.ShopperToProduct;
import com.niq.shoppers_data.persistance.exceptions.DatabaseException;
import com.niq.shoppers_data.persistance.mappers.ShopperToProductMapper;
import com.niq.shoppers_data.services.ShopperToProductDataServiceImpl;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class ShopperToProductRepositoryImpl implements ShopperToProductRepository {
    private final Logger logger = Logger.getLogger(ShopperToProductRepository.class.getName());
    private final JdbcTemplate jdbcTemplate;
    private final ShopperToProductMapper shopperToProductMapper;

    public ShopperToProductRepositoryImpl(JdbcTemplate jdbcTemplate, ShopperToProductMapper shopperToProductMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.shopperToProductMapper = shopperToProductMapper;
    }

    @Override
    public SaveEntitiesResult saveOrUpdateShopperToProductList(List<ShopperToProduct> shopperToProductList) {
        String sql = "INSERT INTO shopper_to_product (shopperId, productId, relevancyScore, created, modified) VALUES (?, ?, ?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP) " +
                "ON DUPLICATE KEY UPDATE relevancyScore = VALUES(relevancyScore), modified = CURRENT_TIMESTAMP";

        int totalSaved = 0;
        try {
            int[][] saveOperationResult = jdbcTemplate.batchUpdate(sql, shopperToProductList, shopperToProductList.size(),
                    (ps, shopperToProduct) -> {
                        ps.setString(1, shopperToProduct.getShopperId());
                        ps.setString(2, shopperToProduct.getProductId());
                        ps.setDouble(3, shopperToProduct.getRelevancyScore());
                    });

            for (int[] result : saveOperationResult) {
                totalSaved += result.length;
            }
            return new SaveEntitiesResult(totalSaved, shopperToProductList.size() - totalSaved);
        } catch (DataAccessException e) {
            logger.warning("Error saving shopper to product data: " + e.getMessage());
            SaveEntitiesResult saveEntitiesResult = new SaveEntitiesResult();
            List<String> errors = new ArrayList<>();
            errors.add("Error saving shopper to product data: " + e.getMessage());
            saveEntitiesResult.setErrors(errors);
            return saveEntitiesResult;
        }
    }

}
