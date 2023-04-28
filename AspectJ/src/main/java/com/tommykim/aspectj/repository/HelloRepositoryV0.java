package com.tommykim.aspectj.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class HelloRepositoryV0 {

    public void save() {
        log.info("helloRepository 실행");
    }

}
