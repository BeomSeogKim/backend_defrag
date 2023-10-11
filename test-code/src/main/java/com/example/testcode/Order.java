package com.example.testcode;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "orders")
@EqualsAndHashCode
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer price;
    private LocalDateTime orderDate;

    @Builder
    private Order(Integer price, LocalDateTime orderDate) {
        this.price = price;
        this.orderDate = orderDate;
    }

    public static Order createOrder(OrderRequest orderRequest) {
        return Order.builder()
                .price(orderRequest.price())
                .orderDate(orderRequest.orderDate())
                .build();
    }

}
