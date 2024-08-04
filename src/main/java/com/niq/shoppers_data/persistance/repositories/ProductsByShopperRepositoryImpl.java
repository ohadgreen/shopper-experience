package com.niq.shoppers_data.persistance.repositories;

import com.niq.shoppers_data.model.output.ProductByShopper;
import com.niq.shoppers_data.persistance.mappers.ProductByShopperMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductsByShopperRepositoryImpl implements ProductsByShopperRepository {
    private final JdbcTemplate jdbcTemplate;
    private final ProductByShopperMapper productByShopperMapper;

    public ProductsByShopperRepositoryImpl(JdbcTemplate jdbcTemplate, ProductByShopperMapper productByShopperMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.productByShopperMapper = productByShopperMapper;
    }

    @Override
    public List<ProductByShopper> getProductsByShopper(String shopperId, String category, String brand, Integer limit) {
        if (limit == null) {
            limit = 10;
        } else if (limit > 100) {
            limit = 100;
        }

        String sql = """
                SELECT stp.shopperId, stp.productId, p.category, p.brand, stp.relevancyScore
                FROM shopper_to_product stp INNER JOIN products p ON stp.productId = p.productId
                WHERE shopperId = ?\s""";

        if (category != null) {
            sql += "AND p.category = ? ";
        }
        if (brand != null) {
            sql += "AND p.brand = ? ";
        }
        sql += "ORDER BY stp.relevancyScore DESC ";
        sql += "LIMIT " + limit;

        if (category != null && brand != null) {
            return jdbcTemplate.query(sql, productByShopperMapper, shopperId, category, brand);
        } else if (category != null) {
            return jdbcTemplate.query(sql, productByShopperMapper, shopperId, category);
        } else if (brand != null) {
            return jdbcTemplate.query(sql, productByShopperMapper, shopperId, brand);
        } else {
            return jdbcTemplate.query(sql, productByShopperMapper, shopperId);
        }
    }

}
