package com.example.springmvc.controller.request_mapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class RequestMappingController {

    /**
     * RequestMapping에 별다른 method를 지정하지 않는 경우 모든 HttpMethod 허용
     *
     * 권장하지 않는 방식
     */
    @RequestMapping("/request-mapping")
    public String requestMapping() {
        log.info("requestMapping 실행");
        return "ok";
    }

    /**
     * HttpMethod 중 GET 만 허용
     *
     * 그 외 다른 메서드가 호출되면 405 Method Not Allowed 응답.
     */
    @RequestMapping(value = "/request-mapping/get", method = RequestMethod.GET)
    public String requestMappingGet() {
        log.info("requestMappingGet 실행");
        return "ok";
    }
}
