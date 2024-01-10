package ua.shcherbyna.springapp.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.shcherbyna.springapp.dto.OrderDto;
@Repository
public interface OrderRepository extends CrudRepository <OrderDto, Integer> {
}
