package com.example.springmvc.controller.request_parameter;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ModelAttributeController {

    @PostMapping("/model-attribute")
    public Member modelAttribute(@ModelAttribute Member member) {
        return member;
    }
}
