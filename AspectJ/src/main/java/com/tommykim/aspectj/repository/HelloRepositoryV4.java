package com.tommykim.aspectj.repository;

import org.springframework.stereotype.Repository;

@Repository
public class HelloRepositoryV4 {

    public void save() {
        throw new RuntimeException("잘못된 예외");
    }

}
