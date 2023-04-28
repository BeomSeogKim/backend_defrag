package com.tommykim.aspectj.controller;

import com.tommykim.aspectj.service.HelloServiceV3;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello/V3")
@RequiredArgsConstructor
public class HelloControllerV3 {

    private final HelloServiceV3 helloService;

    @GetMapping
    public String hello() {
        helloService.hello();
        return "ok";
    }
}
