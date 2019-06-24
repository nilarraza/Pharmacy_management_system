package com.pms.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pms.model.Doctor;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Integer>{

}
