package com.example.testvelacorp.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrderDto {

    private Long id;

    private Date dateCreate;

    private String customerName;

    private String customerEmail;

    private String customerNumber;

    private Integer status;

    private String address;

    private Double amount;

    private List<OrderDetailDto> orderDetails;
}
