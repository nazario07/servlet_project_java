package entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Product {
    private  int id;
    private String name;
    private String description;
    private double price;
}
