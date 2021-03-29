package com.shijianlin.mapper;

import com.shijianlin.bean.Student;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Repository("studentMapper")
public interface StudentMapper {

    List<Student> findAll();
}
