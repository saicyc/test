package com.chinasoft.web;

import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

import org.springframework.web.bind.annotation.RequestMapping;
@Api(value = "user-apis", description = "有关于用户的CURD操作", position = 5)
@RestController
public class HelloController {
    
    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
    @RequestMapping("/test")
    public String test() {
        return "123";
    }
}
