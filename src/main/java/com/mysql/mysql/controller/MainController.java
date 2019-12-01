package com.mysql.mysql.controller;

import com.mysql.mysql.model.AppUser;
import com.mysql.mysql.model.Booking;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class MainController {

    @GetMapping("/main")
    public String mainPage() {
        return "index";
    }

    @GetMapping("/register")
	public String register(Model model) {
        model.addAttribute("user", new AppUser());
		return "register";
    }

    @GetMapping("/scheduling")
	public String scheduling(Model model) {
        model.addAttribute("user", new AppUser());
        model.addAttribute("listOfUsers", new ArrayList<AppUser>());
        model.addAttribute("booking", new Booking());
        model.addAttribute("listOfBooking", new ArrayList<Booking>());
		return "scheduling";
    }
}