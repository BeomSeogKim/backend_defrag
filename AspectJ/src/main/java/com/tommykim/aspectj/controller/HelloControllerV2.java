package com.tommykim.aspectj.controller;

import com.tommykim.aspectj.service.HelloServiceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello/V2")
@RequiredArgsConstructor
public class HelloControllerV2 {

    private final HelloServiceV2 helloService;

    @GetMapping
    public String hello() {
        helloService.hello();
        return "ok";
    }
}
