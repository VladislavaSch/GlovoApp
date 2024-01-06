package ua.shcherbyna.springapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
        private int id;
        private String name;
        private double cost;
        private int orderId;
}
