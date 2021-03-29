package com.shijianlin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {

    @ResponseBody
    @RequestMapping("/say")
    public String say(){
        return "hello spring";
    }
}
