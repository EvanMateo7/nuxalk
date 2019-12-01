package com.mysql.mysql.dao;

import com.mysql.mysql.model.Booking;
import org.springframework.data.repository.CrudRepository;

public interface BookingDAO extends CrudRepository<Booking, Integer> {

}
