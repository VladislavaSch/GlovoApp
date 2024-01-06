package ua.shcherbyna.springapp.service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ua.shcherbyna.springapp.dto.OrderDto;
import ua.shcherbyna.springapp.dto.ProductDto;
import ua.shcherbyna.springapp.repository.OrderRepository;

import java.util.List;
@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductService productService;

    @Override
    public OrderDto getOrder(int id) {
        return orderRepository.getOrder(id);
    }

    @Override
    public List<OrderDto> getAllOrders() {
        return orderRepository.getAllOrders();
    }

    @Override
    public void addOrder(OrderDto order) {
        orderRepository.addOrder(order);
    }

    @Override
    public void update(int id, OrderDto order) {
        orderRepository.update(id, order);
    }

    @Override
    public void delete(int id) {
        List<ProductDto> productsOfOrder = productService.getByOrderId(id);
        for (ProductDto product : productsOfOrder) {
            productService.delete(product.getId());
        }
        orderRepository.delete(id);
    }

    @Override
    public void refreshCost(int id) {
        OrderDto order = getOrder(id);
        List<ProductDto> products = productService.getByOrderId(order.getId());
        double cost = 0;
        for (ProductDto product : products) {
            cost += product.getCost();
        }
        order.setCost(cost);
        update(id, order);
    }
}
