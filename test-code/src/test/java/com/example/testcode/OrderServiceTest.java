package com.example.testcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class OrderServiceTest {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderService orderService;

    @DisplayName("OrderRequest를 통해 주문을 생성할 수 있다.")
    @Test
    void create() {
        // given
        LocalDateTime orderDate = LocalDateTime.of(2023, 10, 11, 10, 20, 50);
        OrderRequest orderRequest = new OrderRequest(10000, orderDate);

        // when
        OrderResponse orderResponse = orderService.create(orderRequest);

        // then
        Order savedOrder = orderRepository.findById(orderResponse.id()).get();
        assertAll(
                () -> assertThat(savedOrder.getId()).isEqualTo(orderResponse.id()),
                () -> assertThat(savedOrder.getOrderDate()).isEqualTo(orderDate)
        );
    }

    @DisplayName("order id를 통해 order를 조회할 수 있다.")
    @Test
    void find_OK() {
        // given
        LocalDateTime testDateTime = LocalDateTime.of(2023, 10, 11, 13, 00, 00);
        Order order = Order.builder()
                .price(1000)
                .orderDate(testDateTime)
                .build();
        Order savedOrder = orderRepository.save(order);

        // when
        OrderResponse orderResponse = orderService.find(savedOrder.getId());

        // then
        assertAll(
                () -> assertThat(orderResponse.id()).isEqualTo(savedOrder.getId()),
                () -> assertThat(orderResponse.orderDate()).isEqualTo(savedOrder.getOrderDate())
        );
    }

    @DisplayName("잘못된 order id를 조회할 경우 예외가 발생한다.")
    @Test
    void find_InvalidId() {
        // given
        LocalDateTime testDateTime = LocalDateTime.of(2023, 10, 11, 13, 00, 00);
        Order order = Order.builder()
                .price(1000)
                .orderDate(testDateTime)
                .build();
        Order savedOrder = orderRepository.save(order);

        // when && then
        assertThatThrownBy(
                () -> orderService.find(savedOrder.getId() + 1)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("invalid order id");
    }
}
