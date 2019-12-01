package com.mysql.mysql.controller;

import com.mysql.mysql.model.AppUser;
import com.mysql.mysql.model.Booking;
import com.mysql.mysql.service.BookingService;
import com.mysql.mysql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.awt.print.Book;
import java.util.ArrayList;

@Controller
public class MainController {

    @Autowired
    UserService userService;

    @Autowired
    BookingService bookingService;

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
        model.addAttribute("listOfUsers", userService.findAll());
        model.addAttribute("booking", new Booking());
        model.addAttribute("listOfBooking", bookingService.getAllBooking());
		return "scheduling";
    }
}