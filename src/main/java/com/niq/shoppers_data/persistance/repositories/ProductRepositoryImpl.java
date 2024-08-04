package com.niq.shoppers_data.persistance.repositories;

import com.niq.shoppers_data.model.input.Product;
import com.niq.shoppers_data.model.input.SaveEntitiesResult;
import com.niq.shoppers_data.persistance.mappers.ProductMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private final JdbcTemplate jdbcTemplate;
    private final ProductMapper productMapper;

    public ProductRepositoryImpl(JdbcTemplate jdbcTemplate, ProductMapper productMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.productMapper = productMapper;
    }

    @Override
    public SaveEntitiesResult saveOrUpdateProducts(List<Product> productList) {
        String sql = "INSERT INTO products (productId, category, brand, created, modified) " +
                "VALUES (?, ?, ?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP) " +
                "ON DUPLICATE KEY UPDATE " +
                "category = VALUES(category), " +
                "brand = VALUES(brand), " +
                "modified = CURRENT_TIMESTAMP";

        int totalCreated = 0;
        int totalModified = 0;
        try {
            int[] saveOperationResult = jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Product product = productList.get(i);
                    ps.setString(1, product.getProductId());
                    ps.setString(2, product.getCategory());
                    ps.setString(3, product.getBrand());
                }

                @Override
                public int getBatchSize() {
                    return productList.size();
                }
            });

            for (int count : saveOperationResult) {
                if (count == 1) {
                    totalCreated++;
                } else if (count == 2) {
                    totalModified++;
                }
            }
            return new SaveEntitiesResult(totalCreated, totalModified);

        } catch (DataAccessException e) {
            SaveEntitiesResult saveEntitiesResult = new SaveEntitiesResult();
            List<String> errors = new ArrayList<>();
            errors.add("Error saving product data: " + e.getMessage());
            saveEntitiesResult.setErrors(errors);
            return saveEntitiesResult;
        }
    }

    @Override
    public Set<String> getAllCategories() {
        String sql = "SELECT DISTINCT category FROM products";
        return new HashSet<>(jdbcTemplate.queryForList(sql, String.class));
    }

    @Override
    public Set<String> getAllBrands() {
        String sql = "SELECT DISTINCT brand FROM products";
        return new HashSet<>(jdbcTemplate.queryForList(sql, String.class));
    }

    @Override
    public Set<String> getAllProductIds() {
        String sql = "SELECT productId FROM products";
        return new HashSet<>(jdbcTemplate.queryForList(sql, String.class));
    }

}
