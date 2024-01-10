package ua.shcherbyna.springapp.service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.shcherbyna.springapp.dto.OrderDto;
import ua.shcherbyna.springapp.dto.ProductDto;
import ua.shcherbyna.springapp.repository.OrderRepository;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductService productService;

    @Override
    public Optional <OrderDto> getOrder(int id) {
        return orderRepository.findById(id);
    }

    @Override
    public List<OrderDto> getAllOrders() {
        List<OrderDto> orders;
        orders = (List<OrderDto>)orderRepository.findAll();
       return orders;
    }

    @Override
    public void addOrder(OrderDto order) {
        orderRepository.save(order);
    }

    @Override
    public void update(int id, OrderDto order) {
        orderRepository.save(order);
    }

    @Override
    public void delete(int id) {
        List<ProductDto> productsOfOrder = productService.getByOrderId(id);
        for (ProductDto product : productsOfOrder) {
            productService.delete(product.getId());
        }
        orderRepository.deleteById(id);
    }

    @Override
    public void refreshCost(int id) {
        Optional<OrderDto> orderOpt = orderRepository.findById(id);
        OrderDto order = orderOpt.orElseGet(OrderDto::new);

        List<ProductDto> products = productService.getByOrderId(order.getId());
            double cost = 0;
            for (ProductDto product : products) {
                cost += product.getCost();
            }
            order.setCost(cost);
            update(id, order);
        }
    }
