package com.example.testvelacorp.dto;

import lombok.Data;

@Data
public class OrderDetailDto {

    private  OrderDetailPKDto id;

    private Integer quantity;

    private ProductDto product;

    private Double amount;
}
