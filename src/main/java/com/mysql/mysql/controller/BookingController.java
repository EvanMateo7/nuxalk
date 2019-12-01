package com.mysql.mysql.controller;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import com.mysql.mysql.model.AppUser;
import com.mysql.mysql.model.Booking;
import com.mysql.mysql.service.BookingService;
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
public class BookingController {

    @Autowired
    public BookingService bookingService;

    @GetMapping("/booking/{insuranceNumber}")
    @ResponseBody
    public Booking getBookingByInusranceNumber(@PathVariable String insuranceNumber) {
        try{
            return bookingService.getBookingByAppUserInsuranceNumber(insuranceNumber);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @PostMapping("/booking")
    public void processBooking(@ModelAttribute Booking booking){
        System.out.println(booking);
        bookingService.addBooking(booking);
    }
}
