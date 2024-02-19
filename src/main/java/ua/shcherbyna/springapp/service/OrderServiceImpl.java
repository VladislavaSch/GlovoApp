package ua.shcherbyna.springapp.service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.shcherbyna.springapp.dto.OrderDto;
import ua.shcherbyna.springapp.dto.ProductDto;
import ua.shcherbyna.springapp.model.Order;
import ua.shcherbyna.springapp.repository.OrderRepository;
import ua.shcherbyna.springapp.repository.mapper.OrderMapper;

import java.util.List;
import java.util.Optional;
@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductService productService;
    private final OrderMapper orderMapper;

    @Override
    public OrderDto getOrder(int id) {
        Optional<Order> orderOptional = orderRepository.findById(id);
        Order order = orderOptional.orElse(null);
        if(order == null) log.error("There is no order with such ID");
        return orderMapper.toDto(order);
    }

    @Override
    public List<OrderDto> getAllOrders() {
        List<Order> orderList = (List<Order>) orderRepository.findAll();
        return orderMapper.toDtoList(orderList);
    }


    @Override
    public void addOrder(OrderDto orderDto) {
        Order order = orderMapper.toEntity(orderDto);
        orderRepository.save(order);
        log.debug("Created new order with ID: " + order.getId());
    }

    @Override
    public void update(OrderDto orderDto) {
        Order order = orderMapper.toEntity(orderDto);
        orderRepository.save(order);
        log.debug("Updated order with ID: " + order.getId());
    }

    @Override
    public void delete(int id) {
        Optional<Order> orderOptional = orderRepository.findById(id);
        Order order = orderOptional.orElse(null);
        if(order == null) log.error("No order found");

        List<ProductDto> productsOfOrder = productService.getByOrderId(id);
        for (ProductDto product : productsOfOrder) {
            productService.delete(product.getId());
        }
        log.trace("Deleted order with ID: " + id);
        orderRepository.deleteById(id);
    }

    @Override
    public void refreshCost(int id) {
        OrderDto orderDto = getOrder(id);

        List<ProductDto> products = productService.getByOrderId(orderDto.getId());
            double cost = 0;
            for (ProductDto product : products) {
                cost += product.getCost();
            }
            orderDto.setCost(cost);
            update(orderDto);
        }
    }
