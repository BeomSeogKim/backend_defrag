package com.tommykim.enumvalidator.domain;

import lombok.Getter;

@Getter
public class Member {
    private String email;
    private Gender gender;

    public Member(String email, Gender gender) {
        this.email = email;
        this.gender = gender;
    }
}
