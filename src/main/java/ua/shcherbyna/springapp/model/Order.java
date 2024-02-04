package ua.shcherbyna.springapp.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.relational.core.mapping.Table;
import ua.shcherbyna.springapp.dto.OrderDto;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "orders")

public class Order {


    @Id
    @GeneratedValue
    private int id;
    private LocalDate date;
    private double cost;


    @OneToMany(cascade = CascadeType.ALL)
    private List <Product> products;
}
