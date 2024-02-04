package ua.shcherbyna.springapp.repository.mapper;

import org.mapstruct.Mapper;
import org.springframework.jdbc.core.RowMapper;
import ua.shcherbyna.springapp.dto.ProductDto;
import ua.shcherbyna.springapp.model.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Mapper
public interface ProductMapper {
    ProductDto toDto(Product entity);
    Product toEntity(ProductDto dto);
    List<ProductDto> toDtoList(List<Product> productList);
}
