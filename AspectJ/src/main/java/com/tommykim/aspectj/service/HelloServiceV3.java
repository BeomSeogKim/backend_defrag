package com.tommykim.aspectj.service;

import com.tommykim.aspectj.repository.HelloRepositoryV3;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HelloServiceV3 {

    private final HelloRepositoryV3 helloRepository;
    public void hello() {
        helloRepository.save();
    }
}
