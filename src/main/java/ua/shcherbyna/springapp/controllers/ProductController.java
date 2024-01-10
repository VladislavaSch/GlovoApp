package ua.shcherbyna.springapp.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.shcherbyna.springapp.dto.OrderDto;
import ua.shcherbyna.springapp.dto.ProductDto;
import ua.shcherbyna.springapp.service.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping()
    public List<ProductDto> getAllProducts() {
        return productService.getAll();
    }
//Change later
    @GetMapping("/{id}")
    public ProductDto getProduct(@PathVariable("id") int id) {
        Optional<ProductDto> productDto = productService.getProduct(id);
        return productDto.orElseGet(ProductDto::new);
    }

    @PostMapping()
    public void createProduct(@RequestBody ProductDto product) {
        productService.addProduct(product);
    }

    @PutMapping("/{id}")
    public void updateProduct(@PathVariable("id") int id, @RequestBody ProductDto product) {
        productService.update(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") int id) {
        productService.delete(id);
    }
}
