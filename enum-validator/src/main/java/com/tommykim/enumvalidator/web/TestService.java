package com.tommykim.enumvalidator.web;

import com.tommykim.enumvalidator.domain.Gender;
import com.tommykim.enumvalidator.domain.Member;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    public Member save(RequestDto requestDto) {
        Gender gender;
        String requestGender = requestDto.getGender();
        if (requestGender.equals("male")) {
            gender = Gender.MALE;
        } else if (requestGender.equals("female")) {
            gender = Gender.FEMALE;
        } else {
            gender = Gender.FEMALE;
        }
        return new Member(requestDto.getEmail(), gender);
    }
}
