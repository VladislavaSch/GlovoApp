package ua.shcherbyna.springapp.repository.mapper;

import org.springframework.jdbc.core.RowMapper;
import ua.shcherbyna.springapp.dto.OrderDto;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapper implements RowMapper <OrderDto> {

    @Override
    public OrderDto mapRow(ResultSet resultSet, int i) throws SQLException {
        OrderDto order = new OrderDto();
        order.setId(resultSet.getInt("id"));
        order.setDate(resultSet.getDate("date").toLocalDate());
        order.setCost(resultSet.getDouble("cost"));
        return order;
    }
}
