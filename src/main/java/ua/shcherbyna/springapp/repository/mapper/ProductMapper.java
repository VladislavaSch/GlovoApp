package ua.shcherbyna.springapp.repository.mapper;

import org.springframework.jdbc.core.RowMapper;
import ua.shcherbyna.springapp.dto.ProductDto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements RowMapper<ProductDto> {
    @Override
    public ProductDto mapRow(ResultSet resultSet, int i) throws SQLException {
        ProductDto product = new ProductDto();
        product.setId(resultSet.getInt("id"));
        product.setName(resultSet.getString("name"));
        product.setCost(resultSet.getDouble("cost"));
        product.setOrderId(resultSet.getInt("orders_key"));

        return product;
    }
}
