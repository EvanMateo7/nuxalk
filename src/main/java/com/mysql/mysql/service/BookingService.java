package com.mysql.mysql.service;

import com.mysql.mysql.dao.api.BookingDAO;
import com.mysql.mysql.exceptions.BookingNotFoundException;
import com.mysql.mysql.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingDAO bookingDAO;

    public void addBooking(Booking booking){
        bookingDAO.save(booking);
    }

    public void deleteBooking(Booking booking){
        bookingDAO.delete(booking);
    }

    public List<Booking> getAllBooking() {
        Iterable<Booking> bookingIterable = bookingDAO.findAll();
        ArrayList<Booking> bookings = new ArrayList<>();
        bookingIterable.forEach(booking -> bookings.add(booking));
        return bookings;
    }

    public void deleteBookingById(int bookingId){
        bookingDAO.deleteById(bookingId);
    }

    public Booking getBookingByAppUserInsuranceNumber(String insuranceNumber) throws BookingNotFoundException {
        return bookingDAO.findBookingByAppUserInsuranceNumber(insuranceNumber).orElseThrow(() -> {
            return new BookingNotFoundException("The booking has not been found using this insuranceNumber");
        });
    }

    public Booking getBookingByAppUserUsername(String username) throws BookingNotFoundException{
        return bookingDAO.findBookingByAppUserUsername(username).orElseThrow(() -> {
            return new BookingNotFoundException("The booking has not been found using this username");
        });
    }

    public long count(){
        return bookingDAO.count();
    }
}
