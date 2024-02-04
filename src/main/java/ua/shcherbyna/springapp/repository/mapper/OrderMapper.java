package ua.shcherbyna.springapp.repository.mapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ua.shcherbyna.springapp.dto.OrderDto;
import ua.shcherbyna.springapp.model.Order;
import java.util.List;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);
    @Mapping(source = "id", target = "id")
    OrderDto toDto(Order order);
    @Mapping(source = "id", target = "id")
    Order toEntity(OrderDto dto);

    List<OrderDto> toDtoList(List<Order> orders);

    List<Order> toEntityList(List<OrderDto> dtos);
}
