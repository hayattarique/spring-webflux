package org.boot.reactive.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("product")
public class Product {
    @Id
    private Integer productId;
    private String productName;
    private String productDescription;
    private double price;
    private String category;
}
