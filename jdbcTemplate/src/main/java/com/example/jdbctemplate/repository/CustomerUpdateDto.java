package com.example.jdbctemplate.repository;

import lombok.Data;

@Data
public class CustomerUpdateDto {
    private String customerName;
    private Integer age;
    private String phoneNumber;

    public CustomerUpdateDto() {
    }

    public CustomerUpdateDto(String customerName, Integer age, String phoneNumber) {
        this.customerName = customerName;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }
}
