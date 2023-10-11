package com.example.testcode;

import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class OrderRepositoryTest {

    @Autowired
    OrderRepository orderRepository;

    @DisplayName("아이디를 통해 Order를 조회할 수 있다.")
    @Test
    void findById() {
        LocalDateTime testDateTime = LocalDateTime.of(2023, 10, 11, 13, 00, 00);
        // given
        Order order = Order.builder()
                .price(1000)
                .orderDate(testDateTime)
                .build();
        orderRepository.save(order);

        // when
        Order savedOrder = orderRepository.findById(order.getId()).get();

        // then
        assertThat(savedOrder).isEqualTo(order);
    }

    @DisplayName("파라미터로 주어진 일자 이후에 생성된 Order에 대해서 조회할 수 있다.")
    @Test
    void findAfterMonth() {
        // given
        LocalDateTime standardDate = LocalDateTime.of(2023, 8, 1, 0, 0, 0);
        LocalDateTime beforeStandard =
                LocalDateTime.of(2023, 7, 31, 23, 59, 59);
        Order order1 = Order.builder()
                .price(1000)
                .orderDate(beforeStandard)
                .build();
        LocalDateTime afterStandard =
                LocalDateTime.of(2023, 8, 1, 0, 0, 1);
        Order order2 = Order.builder()
                .price(1000)
                .orderDate(afterStandard)
                .build();
        orderRepository.saveAll(List.of(order1, order2));

        // when
        List<Order> orders = orderRepository.findAfterMonth(standardDate);

        // then
        assertThat(orders).hasSize(1)
                .extracting("price", "orderDate")
                .contains(Tuple.tuple(order2.getPrice(), order2.getOrderDate()));
    }
}
