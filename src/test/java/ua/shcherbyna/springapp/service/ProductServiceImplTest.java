package ua.shcherbyna.springapp.service;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.shcherbyna.springapp.dto.ProductDto;
import ua.shcherbyna.springapp.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {
    private final int id = 1;

    @InjectMocks
    private ProductServiceImpl productService;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductDto product;


    @Test
    public void getProductTest() {
        when(productRepository.findById(anyInt())).thenReturn(Optional.of(product));

        productService.getProduct(id);

        verify(productRepository).findById(id);
    }


    @Test
    public void findAllTest() {
        List<ProductDto> list = new ArrayList<>();

        when(productRepository.findAll()).thenReturn(list);

        productService.getAll();

        verify(productRepository).findAll();
    }


    @Test
    public void addProductTest() {
        productService.addProduct(product);

        verify(productRepository).save(product);
    }

    @Test
    public void updateTest() {
        productService.update(id, product);

        verify(productRepository).save(product);
    }


    @Test
    public void deleteTest() {
        productService.delete(id);

        verify(productRepository).deleteById(id);
    }

}
