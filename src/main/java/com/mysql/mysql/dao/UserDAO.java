package com.mysql.mysql.dao;

import java.util.Optional;

import com.mysql.mysql.model.AppUser;

import org.springframework.data.repository.CrudRepository;

public interface UserDAO extends CrudRepository<AppUser, Integer> {
    public Optional<AppUser> findByUsername(String username);
}