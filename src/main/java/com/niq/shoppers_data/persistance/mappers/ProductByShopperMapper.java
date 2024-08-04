package com.niq.shoppers_data.persistance.mappers;

import com.niq.shoppers_data.model.output.ProductByShopper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
@Component
public class ProductByShopperMapper implements RowMapper<ProductByShopper> {
    @Override
    public ProductByShopper mapRow(ResultSet rs, int rowNum) throws SQLException {
        ProductByShopper productByShopper = new ProductByShopper();
        productByShopper.setShopperId(rs.getString("shopperId"));
        productByShopper.setProductId(rs.getString("productId"));
        productByShopper.setCategory(rs.getString("category"));
        productByShopper.setBrand(rs.getString("brand"));
        productByShopper.setRelevancyScore(rs.getDouble("relevancyScore"));
        return productByShopper;
    }
}
