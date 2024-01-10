package ua.shcherbyna.springapp.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
        @Id
        private int id;
        private String name;
        private double cost;
        private int orderId;
}
