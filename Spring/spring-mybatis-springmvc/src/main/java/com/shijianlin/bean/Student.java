package com.shijianlin.bean;


import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student implements Serializable {

    private String id;
    private String name;
    private Integer age;
    private Date birthday;
    private String address;
}
