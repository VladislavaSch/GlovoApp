package ua.shcherbyna.springapp.service;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ua.shcherbyna.springapp.dto.OrderDto;
import ua.shcherbyna.springapp.dto.ProductDto;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IntegrationTests {

    private OrderService orderService;
    private ProductService productService;

    @Test
     void testAddAndGetOrder() {

        OrderDto orderDto = new OrderDto();
        orderDto.setDate(LocalDate.now());
        orderDto.setCost(100.0);

        orderService.addOrder(orderDto);
        OrderDto retrievedOrder = orderService.getOrder(orderDto.getId());

        assertNotNull(retrievedOrder);
        assertEquals(orderDto.getDate(), retrievedOrder.getDate());
        assertEquals(orderDto.getCost(), retrievedOrder.getCost());
    }

    @Test
     void testAddAndUpdateProduct() {
        ProductDto productDto = new ProductDto();
        productDto.setName("Test Product");
        productDto.setCost(50.0);

        productService.addProduct(productDto);

        productDto.setCost(60.0);
        productService.update(productDto.getId(), productDto);

        ProductDto updatedProduct = productService.getProduct(productDto.getId());

        assertNotNull(updatedProduct);
        assertEquals(productDto.getName(), updatedProduct.getName());
        assertEquals(productDto.getCost(), updatedProduct.getCost());
    }

    @Test
     void testDeleteOrder() {

        OrderDto orderDto = new OrderDto();
        orderDto.setDate(LocalDate.now());
        orderDto.setCost(100.0);
        orderService.addOrder(orderDto);

        orderService.delete(orderDto.getId());


        OrderDto deletedOrder = orderService.getOrder(orderDto.getId());
        assertNull(deletedOrder);
    }

    @Test
     void testGetProductsByOrderId() {
        OrderDto orderDto = new OrderDto();
        orderDto.setDate(LocalDate.now());
        orderDto.setCost(100.0);
        orderService.addOrder(orderDto);

        ProductDto productDto1 = new ProductDto();
        productDto1.setName("Product 1");
        productDto1.setCost(50.0);
        productDto1.setOrderId(orderDto.getId());
        productService.addProduct(productDto1);

        ProductDto productDto2 = new ProductDto();
        productDto2.setName("Product 2");
        productDto2.setCost(30.0);
        productDto2.setOrderId(orderDto.getId());
        productService.addProduct(productDto2);

        List<ProductDto> productsByOrderId = productService.getByOrderId(orderDto.getId());

        assertNotNull(productsByOrderId);
        assertEquals(2, productsByOrderId.size());
        assertEquals(productDto1, productsByOrderId.get(0));
        assertEquals(productDto2, productsByOrderId.get(1));
    }
}