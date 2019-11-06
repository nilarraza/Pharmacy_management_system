package com.pms.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.dao.DrOrderRepository;
import com.pms.dao.OrderRepository;
import com.pms.model.DrOrderDetails;
import com.pms.model.orderDetails;

@Service
public class orderService {
	@Autowired
	OrderRepository orderRepo;
	@Autowired
	DrOrderRepository drorderRepo;
	
	public Collection<orderDetails> findAllOrders() {
		ArrayList<orderDetails> drug = new ArrayList<orderDetails>();
		for (orderDetails iterable_element : orderRepo.findAll()) {
			drug.add(iterable_element);
		}
		return (Collection<orderDetails>) drug;

	}
	
	public Collection<DrOrderDetails> findAllDrOrders() {
		ArrayList<DrOrderDetails> drug = new ArrayList<DrOrderDetails>();
		for (DrOrderDetails iterable_element : drorderRepo.findAll()) {
			drug.add(iterable_element);
		}
		return (Collection<DrOrderDetails>) drug;

	}
	
	public Collection<DrOrderDetails> findByIdDrOrders(int id) {
		ArrayList<DrOrderDetails> drug = new ArrayList<DrOrderDetails>();
		for (DrOrderDetails iterable_element : drorderRepo.findByUser(id)){
			drug.add(iterable_element);
		}
		return (Collection<DrOrderDetails>) drug;

	}
	
	public Collection<orderDetails> findByIdCrOrders(int id) {
		ArrayList<orderDetails> drug = new ArrayList<orderDetails>();
		for (orderDetails iterable_element : orderRepo.findByUser(id)){
			drug.add(iterable_element);
		}
		return (Collection<orderDetails>) drug;

	}
	
	


}
