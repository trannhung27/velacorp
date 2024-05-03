package com.example.testvelacorp.repository;

import com.example.testvelacorp.modal.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


    @Query(nativeQuery = true, value = "SELECT * FROM product p WHERE  (:name is null or p.name like CONCAT(:name, '%')) OR (:description is null or p.description like CONCAT(:description, '%')) ",
            countQuery = "SELECT count(*) FROM product p WHERE  (:name is null or p.name like CONCAT(:name, '%')) OR (:description is null or p.description like CONCAT(:description, '%')) ")
    Page<Product> findAllProduct(@Param("name") String name, @Param("description")String description, Pageable pageable);

}
