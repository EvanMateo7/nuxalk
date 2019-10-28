package com.mysql.mysql.dao;

import com.mysql.mysql.model.Patient;

import org.springframework.data.repository.CrudRepository;

public interface PatientDAO extends CrudRepository<Patient, Integer> {

}