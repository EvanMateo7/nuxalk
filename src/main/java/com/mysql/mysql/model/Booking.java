package com.mysql.mysql.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name="booking")
public class Booking {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @NotNull
    private String time;

    @OneToOne(cascade=CascadeType.PERSIST)
    private AppUser appUser;

    @Column(name = "patient_id", insertable = false, updatable = false)
    private String patientID;

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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String toString(){
        return "The booking date is: " + this.getDate().toString() + ". This booking starts at " + getTime() + " with patient: " +  getAppUser().getLastName() + ", " + getAppUser().getFirstName() + ".";
    }
}
