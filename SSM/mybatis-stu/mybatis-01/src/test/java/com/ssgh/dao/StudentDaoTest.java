package com.ssgh.dao;

import com.ssgh.pojo.Student;
import com.ssgh.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class StudentDaoTest {
    @Test
    public void test01() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Student student = studentMapper.getStudentById(1);
        System.out.println(student);
        sqlSession.close();
    }
    @Test
    public void test02() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        int res = studentMapper.addStudent(new Student(1, "ssgh"));
        if (res > 0) {
            System.out.println(res);
            sqlSession.commit();
        }
        sqlSession.close();
    }
}
