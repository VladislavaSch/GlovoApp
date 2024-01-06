package ua.shcherbyna.springapp.controllers;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.shcherbyna.springapp.dto.OrderDto;
import ua.shcherbyna.springapp.service.OrderService;


import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class MyController {

    private final OrderService orderService;


    @GetMapping()
    public List<OrderDto> getAll() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public OrderDto order(@PathVariable("id") int id) {
        return orderService.getOrder(id);
    }

    @GetMapping("/new")
    public void newOrder() {
        OrderDto order = new OrderDto();
        order.setDate(LocalDate.now());
        order.setCost(25);
        orderService.addOrder(order);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id){
        orderService.delete(id);
    }
    @GetMapping("/update/{id}")
    public void update(@PathVariable("id") int id) {
        OrderDto order = orderService.getOrder(id);
        orderService.update(id, order);
    }
}
