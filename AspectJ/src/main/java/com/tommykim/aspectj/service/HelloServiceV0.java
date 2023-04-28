package com.tommykim.aspectj.service;

import com.tommykim.aspectj.repository.HelloRepositoryV0;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class HelloServiceV0 {

    private final HelloRepositoryV0 helloRepository;
    public void hello() {
      log.info("hello Service 실행");
        helloRepository.save();
    }
}
