package com.example.springmvc.controller.request_parameter;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class RequestParameterController {

    @GetMapping("/request-param/v1")
    public String v1(HttpServletRequest request) {
        String username = request.getParameter("username");
        log.info("username = {}", username);
        return "username = " + username;
    }

    @GetMapping("/request-param/v2")
    public String v2(@RequestParam("username") String username) {
        log.info("username = {}", username);
        return "username = " + username;
    }

    @GetMapping("/request-param/v3")
    public String v3(@RequestParam String username) {
        log.info("username = {}", username);
        return "username = " + username;
    }

    @GetMapping("/request-param/v4")
    public String v4(@RequestParam(required = false) String username) {
        log.info("username = {}", username);
        return "username = " + username;
    }

    @GetMapping("/request-param/v5")
    public String v5(@RequestParam(defaultValue = "default NickName") String username) {
        log.info("username = {}", username);
        return "username = " + username;
    }
}
