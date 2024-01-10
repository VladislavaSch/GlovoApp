package ua.shcherbyna.springapp.service;

import ua.shcherbyna.springapp.dto.OrderDto;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    Optional <OrderDto> getOrder(int id);
    List<OrderDto> getAllOrders();
    void addOrder(OrderDto order);
    void update(int id, OrderDto order);
    void delete(int id);
    void refreshCost(int id);
}
