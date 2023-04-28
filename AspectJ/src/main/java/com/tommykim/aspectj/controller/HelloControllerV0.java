package com.tommykim.aspectj.controller;

import com.tommykim.aspectj.service.HelloServiceV0;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/hello/V0")
@RequiredArgsConstructor
public class HelloControllerV0 {

    private final HelloServiceV0 helloService;

    @GetMapping
    public String hello() {
        log.info("hello controller 실행");
        helloService.hello();
        return "ok";
    }
}
