package com.example.springbootjsp.service;

import com.example.springbootjsp.entity.User;

import java.util.List;


public interface UserService {

    List<User> getAllUsers();

    void saveUser(User user);

    User getUser(int id);

    void deleteUser(int id);

}