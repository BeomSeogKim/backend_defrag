package com.example.jdbctemplate.domain;

import lombok.Data;

@Data
public class Customer {
    private Long id;
    private String customerName;
    private Integer age;
    private String phoneNumber;

    public Customer() {
    }

    public Customer(String customerName, Integer age, String phoneNumber) {
        this.customerName = customerName;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }
}
