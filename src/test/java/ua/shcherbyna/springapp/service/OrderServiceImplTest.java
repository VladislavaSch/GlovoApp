package ua.shcherbyna.springapp.service;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.shcherbyna.springapp.dto.OrderDto;
import ua.shcherbyna.springapp.model.Order;
import ua.shcherbyna.springapp.repository.OrderRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class OrderServiceImplTest {

    private final int orderId = 1;

    @InjectMocks
    private OrderServiceImpl orderService;

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private Order order;

    @Mock
    private OrderDto orderDto;


    @Test
    void getOrderTest() {
        when(orderRepository.findById(anyInt())).thenReturn(Optional.of(order));

        orderService.getOrder(orderId);

        verify(orderRepository).findById(orderId);
    }


    @Test
    void getAllOrdersTest() {
        List<Order> list = new ArrayList<>();

        when(orderRepository.findAll()).thenReturn(list);

        orderService.getAllOrders();

        verify(orderRepository).findAll();
    }

    @Test
    void addOrderTest() {
        orderService.addOrder(orderDto);

        verify(orderRepository).save(order);
    }

    @Test
    void updateTest() {
        orderService.update(orderDto);

        verify(orderRepository).save(order);
    }

    @Test
    void deleteTest() {
        orderService.delete(orderId);

        verify(orderRepository).deleteById(orderId);
    }

}