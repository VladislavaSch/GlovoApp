package ua.shcherbyna.springapp.dto;
import lombok.Data;
import java.time.LocalDate;


@Data
public class OrderDto {
        private int id;
        private LocalDate date;
        private double cost;
}
