package com.tommykim.aspectj.service;

import com.tommykim.aspectj.repository.HelloRepositoryV4;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HelloServiceV4 {

    private final HelloRepositoryV4 helloRepository;
    public void hello() {
        helloRepository.save();
    }
}
