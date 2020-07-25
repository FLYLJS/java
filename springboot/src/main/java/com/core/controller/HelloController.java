package com.core.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Administrator
 */
@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello")
    public String sayHello(){
        return "Hello World";
    }
}
