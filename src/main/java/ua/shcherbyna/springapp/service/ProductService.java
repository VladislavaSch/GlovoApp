package ua.shcherbyna.springapp.service;

import ua.shcherbyna.springapp.dto.ProductDto;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Optional<ProductDto> getProduct(int id);
    List<ProductDto> getAll();
    void addProduct(ProductDto order);
    void update(int id, ProductDto order);
    void delete(int id);
    List<ProductDto> getByOrderId(int orderId);
}
