package com.example.jpaauditorwithsecurity.controller.dto;

public record LoginRequest(
    String name,
    String password
) {
}
