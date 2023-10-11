package com.example.testcode;

import java.time.LocalDateTime;

public record OrderResponse(
        Long id,
        Integer price,
        LocalDateTime orderDate
) {
    public static OrderResponse of(Order order) {
        return new OrderResponse(order.getId(), order.getPrice(), order.getOrderDate());
    }
}
