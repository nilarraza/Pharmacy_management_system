package com.pms.dao;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pms.model.DrOrderDetails;
import com.pms.model.orderDetails;

@Repository
public interface OrderRepository extends CrudRepository<orderDetails, Integer> {

	ArrayList<orderDetails> findByUser(int id);
	

}
