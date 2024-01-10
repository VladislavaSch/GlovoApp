package ua.shcherbyna.springapp.service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.shcherbyna.springapp.dto.ProductDto;
import ua.shcherbyna.springapp.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Optional<ProductDto> getProduct(int id) {
        return productRepository.findById(id);
    }

    public List<ProductDto> getAll() {
        List<ProductDto> products;
        products = (List<ProductDto>)productRepository.findAll();
        return products;
    }

    @Override
    public void addProduct(ProductDto product) {
        productRepository.save(product);
    }

    @Override
    public void update(int id, ProductDto product) {
        productRepository.save(product);
    }

    @Override
    public void delete(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductDto> getByOrderId(int id) {
        return (List<ProductDto>)productRepository.getByOrderId(id);
    }
}
