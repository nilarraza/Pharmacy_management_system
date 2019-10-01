package com.pms.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pms.model.Customer;
import com.pms.model.Person;
@Repository
public interface CustomerRepository extends CrudRepository<Customer,Integer>{

	

}
