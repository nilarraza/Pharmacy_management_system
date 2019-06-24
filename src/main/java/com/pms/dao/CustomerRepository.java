package com.pms.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pms.model.Customer;
@Repository
public interface CustomerRepository extends CrudRepository<Customer,Integer>{

}
