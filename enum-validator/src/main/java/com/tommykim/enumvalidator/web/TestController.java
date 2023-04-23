package com.tommykim.enumvalidator.web;

import com.tommykim.enumvalidator.domain.Member;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class TestController {
    private final TestService testService;

    @GetMapping("/test")
    public String test(@RequestBody @Valid RequestDto requestDto) {
        Member member = testService.save(requestDto);
        return member.getEmail();
    }
}
