package ua.shcherbyna.springapp.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.shcherbyna.springapp.dto.OrderDto;
import ua.shcherbyna.springapp.repository.mapper.OrderMapper;

import java.util.List;
@Repository
@RequiredArgsConstructor
public class OrderRepository {

        JdbcTemplate jdbcTemplate;

        public List<OrderDto> getAllOrders()  {
            return jdbcTemplate.query("SELECT * FROM orders", new OrderMapper());
        }

        public OrderDto getOrder(int orderId) {
            return jdbcTemplate.query("SELECT * FROM orders WHERE id = ?", new Object[]{orderId}, new OrderMapper())
                    .stream().findAny().orElse(null);
        }

        public void addOrder(OrderDto order){
            jdbcTemplate.update("INSERT INTO orders VALUES (date=?, cost=?)", order.getDate(), order.getCost());
        }

        public void update( int id, OrderDto order){
            jdbcTemplate.update("UPDATE orders SET date=?, cost=? WHERE id=?", order.getDate(), order.getCost(), id);
        }

        public void delete(int orderId){
            jdbcTemplate.update("DELETE FROM orders WHERE id=?", orderId);
        }
}
