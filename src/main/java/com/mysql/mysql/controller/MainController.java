package com.mysql.mysql.controller;

import com.mysql.mysql.model.AppUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @GetMapping("/main")
    public String mainPage() {
        return "index";
    }

    @GetMapping("/register")
	public String register(Model model) {
        model.addAttribute("user", new AppUser());
		return "/register";
    }
}