package com.mysql.mysql.service;

import com.mysql.mysql.dao.BookingDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    @Autowired
    private BookingDAO bookingDAO;


}
