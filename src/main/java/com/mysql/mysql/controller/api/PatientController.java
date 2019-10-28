package com.mysql.mysql.controller.api;

import java.util.List;

import com.mysql.mysql.dao.PatientDAO;
import com.mysql.mysql.model.Patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("api/patient")
public class PatientController {

    @Autowired
    private PatientDAO patientDB;

    @PostMapping
    public String registerPatient(@RequestBody Patient patient) {
        patientDB.save(patient);
        return "Total patient(s): " + patientDB.count();
    }
    
    @GetMapping
    public List<Patient> getPatients() {
        return (List<Patient>) patientDB.findAll();
    }
}