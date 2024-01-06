package ua.shcherbyna.springapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.shcherbyna.springapp.dto.ProductDto;
import ua.shcherbyna.springapp.repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public ProductDto getProduct(int id) {
        return productRepository.getById(id);
    }

    public List<ProductDto> getAll() {
        return productRepository.getAll();
    }

    @Override
    public void addProduct(ProductDto product) {
        productRepository.add(product);
    }

    @Override
    public void update(int id, ProductDto product) {
        productRepository.updateById(id, product);
    }

    @Override
    public void delete(int id) {
        productRepository.delete(id);
    }

    @Override
    public List<ProductDto> getByOrderId(int orderId) {
        return productRepository.getByOrderId(orderId);
    }
}
