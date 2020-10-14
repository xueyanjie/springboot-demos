package com.demo.mapper;

import com.demo.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface StudentMapper {
    List<Student> findAll();  //对应 mapper的xml中相应的sql配置

    Student findById(int id);

    int insertStudent(Student stu);
}
