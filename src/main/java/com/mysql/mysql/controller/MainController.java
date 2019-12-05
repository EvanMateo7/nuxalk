package com.mysql.mysql.controller;

import com.mysql.mysql.model.AppUser;
import com.mysql.mysql.model.Booking;
import com.mysql.mysql.service.BookingService;
import com.mysql.mysql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.Time;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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
        model.addAttribute("bookingDate", new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime()); //Random Date object created, the initialized values will be replaced by the one inputted by the user
        model.addAttribute("bookingTime", new Time(11111)); //Random value for time initialized.
        model.addAttribute("localDate", java.time.LocalDate.now()); //YYYY-MM-DD
        model.addAttribute("standardDate", new Date());
        model.addAttribute("localDateTime", LocalDateTime.now());
        model.addAttribute("timestamp", Instant.now());
		return "scheduling";
    }
}