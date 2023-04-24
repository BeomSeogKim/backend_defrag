package com.tommykim.enumvalidator.web;

import com.tommykim.enumvalidator.domain.Gender;
import com.tommykim.enumvalidator.validator.EnumValue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class RequestDto {
    @NotNull(message = "null 일 수 없습니다.")
    @NotBlank(message = "공백 입력은 불가합니다.")
    private String email;
    @EnumValue(enumClass = Gender.class, message = "유효하지 않은 성별입니다.", ignoreCase = true)
    private String gender;
}
