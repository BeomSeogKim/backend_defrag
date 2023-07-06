package com.example.springmvc.controller.request_mapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HttpMethodMappingAbstract {

    @GetMapping("/abstract/get-mapping")
    public String getMapping() {
        log.info("getMapping 실행");
        return "ok";
    }

    @PutMapping("/abstract/put-mapping")
    public String putMapping() {
        log.info("putMapping 실행");
        return "ok";
    }

    @DeleteMapping("/abstract/delete-mapping")
    public String deleteMapping() {
        log.info("deleteMapping 실행");
        return "ok";
    }
}
