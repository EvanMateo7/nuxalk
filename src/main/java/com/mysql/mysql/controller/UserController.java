package com.mysql.mysql.controller;

import java.util.List;
import com.mysql.mysql.model.AppUser;
import com.mysql.mysql.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<AppUser> allUsers() {
        return userService.findAll();
    }

    @GetMapping("/users/count")
    public Long count() {
        return userService.count();
    }

    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable String id) {
        int userId = Integer.parseInt(id);
        userService.deleteById(userId);
    }

	@PostMapping("/user")
	public AppUser postRegister(@RequestBody AppUser user) {
		return userService.addUser(user);
	}
}