package com.example.springmvc.controller.request_mapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/abstract2")
public class HttpMethodMappingAbstract2 {

    @GetMapping("/get-mapping")
    public String getMapping() {
        log.info("getMapping 실행");
        return "ok";
    }

    @PutMapping("/put-mapping")
    public String putMapping() {
        log.info("putMapping 실행");
        return "ok";
    }

    @DeleteMapping("/delete-mapping")
    public String deleteMapping() {
        log.info("deleteMapping 실행");
        return "ok";
    }
}
