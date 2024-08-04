package com.niq.shoppers_data.persistance.mappers;

import com.niq.shoppers_data.model.input.ShopperToProduct;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
@Component
public class ShopperToProductMapper implements RowMapper<ShopperToProduct> {
    @Override
    public ShopperToProduct mapRow(ResultSet rs, int rowNum) throws SQLException {
        ShopperToProduct shopperToProduct = new ShopperToProduct();
        shopperToProduct.setShopperId(rs.getString("shopperId"));
        shopperToProduct.setProductId(rs.getString("productId"));
        shopperToProduct.setRelevancyScore(rs.getDouble("relevancyScore"));
        return shopperToProduct;
    }
}
