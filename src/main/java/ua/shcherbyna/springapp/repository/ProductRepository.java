package ua.shcherbyna.springapp.repository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.shcherbyna.springapp.dto.ProductDto;
import ua.shcherbyna.springapp.repository.mapper.ProductMapper;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductRepository {

    private final JdbcTemplate jdbcTemplate;

    public ProductDto getById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM product WHERE id = " + id, new ProductMapper());
    }

    public List<ProductDto> getAll() {
        return jdbcTemplate.query("SELECT * FROM product", new ProductMapper());
    }

    public void add(ProductDto product) {
        jdbcTemplate.update("INSERT INTO product (name, cost, orders_key) VALUES (?, ?, ?)",
                product.getName(), product.getCost(), product.getOrderId());
    }

    public void updateById(int id, ProductDto product) {
        jdbcTemplate.update("UPDATE product SET name = ?, cost = ?, orders_key = ? WHERE id = ?",
                product.getName(), product.getCost(), product.getOrderId(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM product WHERE id = ?", id);
    }

    public List<ProductDto> getByOrderId(int orderId) {
        return jdbcTemplate.query("SELECT * FROM product WHERE orders_key = " + orderId, new ProductMapper());
    }

}
