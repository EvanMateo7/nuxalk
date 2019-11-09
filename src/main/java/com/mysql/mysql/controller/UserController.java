package com.mysql.mysql.controller;

import java.util.List;
import com.mysql.mysql.model.AppUser;
import com.mysql.mysql.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    @ResponseBody
    public List<AppUser> allUsers() {
        return userService.findAll();
    }

    @GetMapping("/users/count")
    @ResponseBody
    public Long count() {
        return userService.count();
    }

    @DeleteMapping("/users/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        int userId = Integer.parseInt(id);
        userService.deleteById(userId);
    }

    @PostMapping("/user")
    public String processRegister(@ModelAttribute AppUser user) {
        System.out.println(user);
		userService.addUser(user);
		return "redirect:/";
	}
}