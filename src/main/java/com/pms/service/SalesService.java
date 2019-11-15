package com.pms.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.dao.SalesRepository;
import com.pms.model.Sales;

@Service
public class SalesService {
	@Autowired
	SalesRepository salesRepo;
	
	public Collection<Sales> findAllSales() {
		ArrayList<Sales> drug = new ArrayList<Sales>();
		for (Sales iterable_element :salesRepo.findAll() ) {
			drug.add(iterable_element);
		}
		return (Collection<Sales>) drug;

	}

}
