package ua.shcherbyna.springapp.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.shcherbyna.springapp.dto.ProductDto;
@Repository
public interface ProductRepository extends CrudRepository<ProductDto, Integer> {
    @Modifying
    @Query("SELECT * FROM products WHERE order_id = :order_id")
    Iterable<ProductDto> getByOrderId(@Param("order_id") int orderId);
}
