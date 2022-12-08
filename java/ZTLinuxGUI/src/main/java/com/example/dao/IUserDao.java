package com.example.dao;

import com.example.domain.User;

import java.util.List;

public interface IUserDao {
    public void save(User user);
    public void delete(int uID);
    public void update(int uID, User user);
    public User get(int uID);
    public List<User> getAll();
}
