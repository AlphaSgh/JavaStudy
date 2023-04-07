package org.ssgh.service;

import org.ssgh.dao.UserDao;
import org.ssgh.dao.UserDaoImpl;
import org.ssgh.dao.UserDaoMySQLImpl;
import org.ssgh.dao.UserDaoOracleImpl;

public class UserServiceImpl implements UserService{

    // private UserDao userDao = new UserDaoOracleImpl();//此处由程序员创建对象，由程序员控制
    private UserDao userDao;
    public void setUserDao(UserDao userDao) { //通过set方法可以将创建对象的控制权交给用户
        this.userDao = userDao;
    }
    @Override
    public void getUser() {
        userDao.getUser();
    }
}
