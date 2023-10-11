package com.example.testcode;

import jakarta.validation.constraints.Positive;

public record OrderWebRequest(
        @Positive(message = "must be positive")
        Integer price
) {

}
