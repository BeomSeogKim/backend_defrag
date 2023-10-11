package com.example.testcode;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    @Transactional
    public OrderResponse create(OrderRequest orderRequest) {
        Order order = Order.createOrder(orderRequest);
        Order savedOrder = orderRepository.save(order);
        return OrderResponse.of(savedOrder);
    }

    public OrderResponse find(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(
                        () -> new IllegalArgumentException("invalid order id")
                );
        return OrderResponse.of(order);
    }
}
