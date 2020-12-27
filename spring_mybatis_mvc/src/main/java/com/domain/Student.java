package com.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Student implements Serializable {

    private String name;
    private Integer age;
    private Date date;
}
