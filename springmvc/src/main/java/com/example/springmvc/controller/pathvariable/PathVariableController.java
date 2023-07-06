package com.example.springmvc.controller.pathvariable;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class PathVariableController {

    @GetMapping("/path-variable/{userId}")
    public String singlePathVariable(@PathVariable String userId) {
        log.info("userId = {}", userId);
        return "userId = " + userId;
    }

    @GetMapping("/path-variable/users/{userId}/orders/{orderId}")
    public String multiplePathVariable(@PathVariable String userId, @PathVariable String orderId) {
        log.info("userId = {}, orderId = {}", userId, orderId);
        return "userId = " + userId + " orderId = " + orderId;
    }
}
