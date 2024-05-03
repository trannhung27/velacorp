package com.example.testvelacorp.modal;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
@ToString
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dateCreate;

    private String customerName;

    private String customerEmail;

    private String customerNumber;

    private Integer status;

    private String address;

    private Double amount;

    @OneToMany(mappedBy = "order")
    private List<OrderDetails> orderDetails;

}
