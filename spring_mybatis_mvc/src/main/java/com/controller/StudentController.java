package com.controller;


import com.domain.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

    @RequestMapping("saveStudent")
    public String saveStudent(Student student){
        System.out.println(student);
        return "success";
    }
}
