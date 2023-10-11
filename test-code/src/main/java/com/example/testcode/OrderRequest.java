package com.example.testcode;

import java.time.LocalDateTime;

public record OrderRequest(
        Integer price,
        LocalDateTime orderDate
) {

}
