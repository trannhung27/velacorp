package com.example.testvelacorp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Long id;
    @NonNull
    private String name;
    private String description;
    private Double price;
    private Integer quantityInStock;

}
