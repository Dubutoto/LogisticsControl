package org.example.logistics;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ProductsVO {
    private int productId;
    private String name;
    private String description;
    private int categoryId;
    private double price;
    private String createdAt;
    private int manufacturerId;
}
