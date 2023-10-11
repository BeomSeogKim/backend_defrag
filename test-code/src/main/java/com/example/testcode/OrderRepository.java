package com.example.testcode;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findById(Long id);

    @Query("select o from Order o where o.orderDate > :orderDate")
    List<Order> findAfterMonth(@Param("orderDate") LocalDateTime orderDate);
}
