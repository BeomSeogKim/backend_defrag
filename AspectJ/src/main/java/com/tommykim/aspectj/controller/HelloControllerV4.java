package com.tommykim.aspectj.controller;

import com.tommykim.aspectj.service.HelloServiceV4;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello/V4")
@RequiredArgsConstructor
public class HelloControllerV4 {

    private final HelloServiceV4 helloService;

    @GetMapping
    public String hello() {
        helloService.hello();
        return "ok";
    }
}
