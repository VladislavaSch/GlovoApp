package ua.shcherbyna.springapp.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Order {
    private int id;
    private LocalDate date = LocalDate.now();
    private double cost;
    private List<Product> products;
    {
        products = new ArrayList<>();
        products.add(new Product("Pen", 25));
        products.add(new Product("Book", 250));
        products.add(new Product("Pencil", 15));
        products.add(new Product("Eraser", 40));
        products.add(new Product("Notebook", 120));

    }


    public Order(){
        calculateOrderCost();
    }

    public void calculateOrderCost() {
        this.cost = products.stream().mapToDouble(Product::getCost).sum();
    }

    @Override
    public String toString() {
        return "Order ID: " + this.getId() + "\n Date: " + this.getDate() + "\n Cost: "
                + this.getCost() + "\n Product: " + this.getProducts();
    }
}
