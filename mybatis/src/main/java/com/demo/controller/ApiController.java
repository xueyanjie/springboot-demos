package com.demo.controller;

import com.demo.utils.ApiResponse;
import com.demo.entity.Student;
import com.demo.mapper.StudentMapper;
import org.apache.logging.log4j.util.Strings;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Resource
    private StudentMapper studentMapper;

    @RequestMapping("getStudents") // http://localhost:8080/api/getStudents
    public ApiResponse<List<Student>> getStudents() {
        List<Student> list = studentMapper.findAll();
        return ApiResponse.retOK(list);
    }

    @RequestMapping("findById") // http://localhost:8080/api/finById
    public ApiResponse<Student> getById(@RequestParam(value = "id", required = false) String id) {
        int idVal = 0;
        if (Strings.isNotEmpty(id)) {
            idVal = Integer.parseInt(id);
        }
        Student stu = studentMapper.findById(idVal);
        return ApiResponse.retOK(stu);
    }
}
