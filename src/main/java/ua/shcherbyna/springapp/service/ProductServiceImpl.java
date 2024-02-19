package ua.shcherbyna.springapp.service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.shcherbyna.springapp.dto.ProductDto;
import ua.shcherbyna.springapp.model.Product;
import ua.shcherbyna.springapp.repository.ProductRepository;
import ua.shcherbyna.springapp.repository.mapper.ProductMapper;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductDto getProduct(int id) {
        Optional<Product> optionalOfProduct = productRepository.findById(id);
        Product product = optionalOfProduct.orElse(null);
        if(product == null) log.error("There is no product with such ID");
        return productMapper.toDto(product);
    }

    public List<ProductDto> getAll() {
        List <Product> productList = (List<Product>) productRepository.findAll();
        return productMapper.toDtoList(productList);
    }

    @Override
    public void addProduct(ProductDto productDto) {
        Product product = productMapper.toEntity(productDto);
        productRepository.save(product);
        log.debug("Added new product: " + product.getName());
    }

    @Override
    public void update(int id, ProductDto productDto) {
        if (productDto == null) {
            throw new IllegalArgumentException("Product must not be null");
        }
        Product product = productMapper.toEntity(productDto);
        product.setId(id);
        productRepository.save(product);
        log.debug("Updated product: " + product.getName());
    }

    @Override
    public void delete(int id) {
        productRepository.deleteById(id);
        log.trace("Deleted product with ID: " + id);
    }

    @Override
    public List<ProductDto> getByOrderId(int id) {
        return (List<ProductDto>)productRepository.getByOrderId(id);
    }
}
