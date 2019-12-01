package com.mysql.mysql.dao.api;

import java.util.Optional;

import com.mysql.mysql.model.AppUser;

import org.springframework.data.repository.CrudRepository;

public interface UserDAO extends CrudRepository<AppUser, Integer> {
    Optional<AppUser> findByUsername(String username);
}