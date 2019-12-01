package com.mysql.mysql.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name="Bookings")
public class Booking {



    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private Time startTime;

    @NotNull
    private Time end;

    @NotNull
    private Time duration;

    @NotNull
    private Date date;


    //add patientId as join table
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEnd() {
        return end;
    }

    public void setEnd(Time end) {
        this.end = end;
    }

    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
