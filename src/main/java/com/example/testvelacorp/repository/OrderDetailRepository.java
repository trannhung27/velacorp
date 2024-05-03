package com.example.testvelacorp.repository;

import com.example.testvelacorp.modal.OrderDetailPK;
import com.example.testvelacorp.modal.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetails, OrderDetailPK> {

    List<OrderDetails> findByIdIdOrder(Long idOrder);
}
