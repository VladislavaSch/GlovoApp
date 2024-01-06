package ua.shcherbyna.springapp.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private int id;
    private String name;
    private double cost;



    public Product (String name, double cost) {
        this.name = name;
        this.cost = cost;
    }
    public Product(){}

    @Override
    public String toString() {
        return getName() +  " ," + getCost();
    }
}
