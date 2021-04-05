package com.shijialin.helloworld.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    /**
     * http://localhost:8080/hello
     */
    @RequestMapping("/hello")
    public String hello() {
        return "hello,world";
    }
}
