package com.example.jpaauditorwithsecurity.service;

import com.example.jpaauditorwithsecurity.controller.dto.LoginRequest;
import com.example.jpaauditorwithsecurity.domain.Member;
import com.example.jpaauditorwithsecurity.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void save(LoginRequest request) {
        memberRepository.save(new Member(request.name(), request.password()));
    }

}
