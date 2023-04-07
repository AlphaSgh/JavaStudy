package com.ssgh.dao;

import com.google.protobuf.DescriptorProtos;
import com.ssgh.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> getUserList();
    User getUserById(int id);
    int addUser(User user);
    int updateUser(User user);
    int deleteUser(int id);
    //万能map
    int addUser2(Map<String, Object> map);
}
