package com.tommykim.aspectj.service;

import com.tommykim.aspectj.repository.HelloRepositoryV1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HelloServiceV1 {

    private final HelloRepositoryV1 helloRepository;
    public void hello() {
        helloRepository.save();
    }
}
