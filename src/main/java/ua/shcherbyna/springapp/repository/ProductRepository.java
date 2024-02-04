package ua.shcherbyna.springapp.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.shcherbyna.springapp.dto.ProductDto;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import ua.shcherbyna.springapp.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
    @Modifying
    @Query("SELECT * FROM product WHERE orders_key = :order_id")
    Iterable<ProductDto> getByOrderId(@Param("order_id") int orderId);
}
