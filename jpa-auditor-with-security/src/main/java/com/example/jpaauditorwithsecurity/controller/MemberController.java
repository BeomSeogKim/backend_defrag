package com.example.jpaauditorwithsecurity.controller;

import com.example.jpaauditorwithsecurity.controller.dto.LoginRequest;
import com.example.jpaauditorwithsecurity.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<String> save(@RequestBody LoginRequest request){
        memberService.save(request);
        return ResponseEntity.ok("Member saved successfully");
    }
}
