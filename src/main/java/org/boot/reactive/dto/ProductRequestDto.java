package org.boot.reactive.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDto {
    private String productName;
    private String productDescription;
    private double price;
    private String category;
}
