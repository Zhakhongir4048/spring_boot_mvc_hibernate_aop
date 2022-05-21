package com.example.springbootjsp.dao;

import com.example.springbootjsp.entity.User;

import java.util.List;


public interface UserDAO {

    List<User> getAllUsers();

    void saveUser(User user);

    User getUser(int id);

    void deleteUser(int id);

}