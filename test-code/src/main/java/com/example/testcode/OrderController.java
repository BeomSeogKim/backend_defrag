package com.example.testcode;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/orders")
    public ResponseEntity<OrderResponse> save(@RequestBody @Valid OrderWebRequest orderWebRequest) {
        LocalDateTime now = LocalDateTime.now();
        OrderResponse orderResponse = orderService.create(new OrderRequest(orderWebRequest.price(), now));
        return ResponseEntity.ok(orderResponse);
    }
}
