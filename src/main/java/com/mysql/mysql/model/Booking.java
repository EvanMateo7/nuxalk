package com.mysql.mysql.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name="booking")
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

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "appUser_id", referencedColumnName = "id")
    private AppUser appUser;

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

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

    public String toString(){
        return "The booking date is: " + this.getDate().toString() + " by patient " + getAppUser().toString() + ". This booking starts at " + getStartTime().toString() + " and ends at " + getEnd() + "."
    }
}
