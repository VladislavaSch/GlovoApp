package ua.shcherbyna.springapp.controllers;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.shcherbyna.springapp.dto.OrderDto;
import ua.shcherbyna.springapp.service.OrderService;

import java.util.List;
@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping()
    public List<OrderDto> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public OrderDto getOrder(@PathVariable("id") int id) {
        return orderService.getOrder(id);
    }

    @PostMapping()
    public void createOrder(@RequestBody OrderDto order) {
        orderService.addOrder(order);
    }

    @PutMapping("/{id}")
    public void updateOrder(@PathVariable("id") int id, @RequestBody OrderDto order) {
        orderService.update(id, order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable("id") int id) {
        orderService.delete(id);
    }
}
