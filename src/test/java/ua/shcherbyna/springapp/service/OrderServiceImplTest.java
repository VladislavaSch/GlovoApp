package ua.shcherbyna.springapp.service;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.shcherbyna.springapp.dto.OrderDto;
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
    private OrderDto order;

    @Test
    void getOrderTest() {
        when(orderRepository.findById(anyInt())).thenReturn(Optional.of(order));

        orderService.getOrder(orderId);

        verify(orderRepository).findById(orderId);
    }


    @Test
    void getAllOrdersTest() {
        List<OrderDto> list = new ArrayList<>();

        when(orderRepository.findAll()).thenReturn(list);

        orderService.getAllOrders();

        verify(orderRepository).findAll();
    }

    @Test
    void addOrderTest() {
        orderService.addOrder(order);

        verify(orderRepository).save(order);
    }

    @Test
    void updateTest() {
        orderService.update(orderId, order);

        verify(orderRepository).save(order);
    }

    @Test
    void deleteTest() {
        orderService.delete(orderId);

        verify(orderRepository).deleteById(orderId);
    }

    @Test
    void RefreshCostTest() {
        when(orderRepository.findById(anyInt())).thenReturn(Optional.of(order));

        Optional<OrderDto> optionalOfOrderDTO = orderRepository.findById(orderId);
        OrderDto result = null;
        if (optionalOfOrderDTO.isPresent()) {
            result = optionalOfOrderDTO.get();
            orderRepository.save(result);
        }

        orderService.refreshCost(orderId);

        verify(orderRepository, times(2)).findById(orderId);
        assert result != null;
        verify(orderRepository, times(2)).save(result);
    }
}