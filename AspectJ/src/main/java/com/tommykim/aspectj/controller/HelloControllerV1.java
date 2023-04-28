package com.tommykim.aspectj.controller;

import com.tommykim.aspectj.service.HelloServiceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello/V1")
@RequiredArgsConstructor
public class HelloControllerV1 {

    private final HelloServiceV1 helloService;

    @GetMapping
    public String hello() {
        helloService.hello();
        return "ok";
    }
}
