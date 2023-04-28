package com.tommykim.aspectj.service;

import com.tommykim.aspectj.repository.HelloRepositoryV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HelloServiceV2 {

    private final HelloRepositoryV2 helloRepository;
    public void hello() {
        helloRepository.save();
    }
}
