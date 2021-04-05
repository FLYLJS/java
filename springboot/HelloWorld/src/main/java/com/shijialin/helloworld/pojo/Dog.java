package com.shijialin.helloworld.pojo;


import lombok.*;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Component
public class Dog {


    private String name;
    private Integer age;
}
