package com.mysql.mysql.dao.api;

import com.mysql.mysql.model.Booking;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BookingDAO extends CrudRepository<Booking, Integer> {
    Optional<Booking> findBookingByAppUserInsuranceNumber(String insuranceNumber);

    Optional<Booking> findBookingByAppUserUsername(String username);

    Optional<Booking> findBookingByUserId();
}
