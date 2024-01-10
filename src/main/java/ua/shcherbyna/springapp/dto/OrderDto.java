package ua.shcherbyna.springapp.dto;
import lombok.Data;
import org.springframework.data.annotation.Id;
import java.time.LocalDate;

@Data
public class OrderDto {
        @Id
        private int id;
        private LocalDate date;
        private double cost;
}
