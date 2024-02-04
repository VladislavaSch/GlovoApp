package ua.shcherbyna.springapp.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.shcherbyna.springapp.dto.OrderDto;
import ua.shcherbyna.springapp.model.Order;

@Repository
public interface OrderRepository extends CrudRepository <Order, Integer> {
}
