package com.ssgh.dao;

import com.ssgh.pojo.User;
import com.ssgh.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {
    @Test
    public void test01() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.getUserList();
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }
    @Test
    public void test02() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserById(1);
        System.out.println(user);
        sqlSession.close();
    }
    @Test
    public void test03() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int result = userMapper.addUser(new User(4, "sgh", "sgh"));
        if (result > 0) {
            sqlSession.commit();
            System.out.println(result);
        }
        sqlSession.close();
    }
    @Test
    public void test04() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int result = userMapper.updateUser(new User(1, "sgh", "sgh"));
        if (result > 0) {
            sqlSession.commit();
            System.out.println(result);
        }
        sqlSession.close();
    }
    @Test
    public void test05() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int result = userMapper.deleteUser(4);
        if (result > 0) {
            sqlSession.commit();
            System.out.println(result);
        }
        sqlSession.close();
    }
    @Test
    public void test06() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        Map<String, Object> map = new HashMap<>();
        map.put("userId", 7);
        map.put("userName", "ssgh");
        map.put("userPwd", "111111");
        int result = userMapper.addUser2(map);

        if (result > 0) {
            sqlSession.commit();
            System.out.println(result);
        }
        sqlSession.close();
    }
}
