package com.example.springmvc.controller.request_parameter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class RequestBodyController {

    @PostMapping("request-body")
    public String requestBody(@RequestBody String messageBody) {
        log.info("message Body = {}", messageBody);
        return messageBody;
    }
}
