package com.example.testvelacorp.repository;

import com.example.testvelacorp.modal.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {


    @Query(nativeQuery = true, value = "SELECT * FROM orders o WHERE  (:customerName is null or o.customer_name like CONCAT(:customerName, '%')) OR (:idOrder is null or o.id = :idOrder)",
    countQuery = "SELECT count(*) FROM orders o WHERE  (:customerName is null or o.customer_name like CONCAT(:customerName, '%')) OR (:idOrder is null or o.id = :idOrder)")
    Page<Order> findAllOrder(@Param("customerName") String customerName, @Param("idOrder")Long idOrder, Pageable pageable);

}
