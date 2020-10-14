package com.demo.mapper;

import com.demo.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface StudentMapper {
    List<Student> findAll();
}
