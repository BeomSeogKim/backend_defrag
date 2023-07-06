package com.example.springmvc.controller.request;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class RequestController {

    @GetMapping("/request-param/query")
    public void requestQueryParam(HttpServletRequest request, HttpServletResponse response) {

    }
}
