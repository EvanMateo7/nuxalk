package com.mysql.mysql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

import com.mysql.mysql.dao.UserDAO;
import com.mysql.mysql.model.User;

@Service
public class UserService {

    @Autowired
    private UserDAO userDB;

    public List<User> findAll() {
        Iterable<User> allUsers = userDB.findAll();
        ArrayList<User> users = new ArrayList<User>();
        allUsers.forEach(user -> users.add(user));
        return users;
    }

    public long count() {
        return userDB.count();
    }

    public void deleteById(int userId) {
        userDB.deleteById(userId);
    }

    public User addUser(User user) {
        return userDB.save(user);
    }
}