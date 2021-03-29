package com.shijianlin.service.impl;

import com.shijianlin.bean.Student;
import com.shijianlin.mapper.StudentMapper;
import com.shijianlin.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;
    @Override
    public List<Student> findAll() {
        return studentMapper.findAll();
    }
}
