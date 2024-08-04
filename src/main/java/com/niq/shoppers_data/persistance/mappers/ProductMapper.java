package com.niq.shoppers_data.persistance.mappers;

import com.niq.shoppers_data.model.input.Product;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ProductMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product product = new Product();
        product.setProductId(rs.getString("productId"));
        product.setCategory(rs.getString("category"));
        product.setBrand(rs.getString("brand"));
        product.setCreated(rs.getTimestamp("created").toLocalDateTime());
        product.setModified(rs.getTimestamp("modified").toLocalDateTime());
        return product;
    }

}
