package ua.shcherbyna.springapp.service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.shcherbyna.springapp.dto.ProductDto;
import ua.shcherbyna.springapp.model.Product;
import ua.shcherbyna.springapp.repository.ProductRepository;
import ua.shcherbyna.springapp.repository.mapper.ProductMapper;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductDto getProduct(int id) {
        Optional<Product> optionalOfProduct = productRepository.findById(id);
        Product product = new Product();
        if(optionalOfProduct.isPresent()) {
            product = optionalOfProduct.get();
        }
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
    }

    @Override
    public void update(int id, ProductDto productDto) {
        Product product = productMapper.toEntity(productDto);
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
