package com.ssgh.dao;

import com.ssgh.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;

public interface UserMapper {

    List<User> getUserList();
    List<User> getUserByLimit(HashMap<String, Object> map);
}
