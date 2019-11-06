package com.pms.dao;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pms.model.DrOrderDetails;
import com.pms.model.Drugs;

@Repository
public interface DrOrderRepository extends CrudRepository<DrOrderDetails, Integer>{

	

	ArrayList<DrOrderDetails> findByUser(int id);

}
