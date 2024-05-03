package com.example.testvelacorp.modal;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@Getter
@Setter
@ToString
public class OrderDetailPK implements Serializable {
    private Long idOrder;

    private Long idProduct;
}
