package com.ssgh.dao;

import com.ssgh.pojo.Student;

public interface StudentMapper {
    Student getStudentById(int id);

    int addStudent(Student student);
}
