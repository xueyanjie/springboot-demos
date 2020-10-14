package com.demo.controller;

import com.demo.entity.Student;
import com.demo.mapper.StudentMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Resource
    private StudentMapper studentMapper;

    @RequestMapping("getStudents")
    public List<Student> getStudents() {
        return studentMapper.findAll();
    }
}
