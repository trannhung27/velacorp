package com.example.testvelacorp.modal;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Entity
@Table(name = "order_details")
@ToString
@Getter
@Setter
public class OrderDetails implements Serializable {

    @EmbeddedId
    private OrderDetailPK id;

    private Integer quantity;

    @ManyToOne
    @MapsId("idOrder")
    @JoinColumn(name = "id_order")
    private Order order;

    @ManyToOne
    @MapsId("idProduct")
    @JoinColumn(name = "id_product")
    private Product product;
}
