package com.shijialin.helloworld.pojo;


import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Component
@ConfigurationProperties(prefix = "person")
/**
 *  JSR303数据校验
 *  @Validated
 */
//@Validated
public class Person {
    private String name;
    private Integer age;
    private Date birth;
    private Map<String, Object> maps;
    private List<Object> lists;
    private Dog dog;

    //    @Email
    private String email;

}
