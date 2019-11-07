package com.mysql.mysql.dao;

import com.mysql.mysql.model.User;

import org.springframework.data.repository.CrudRepository;

public interface UserDAO extends CrudRepository<User, Integer> {

}