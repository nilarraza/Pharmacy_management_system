package com.pms.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.dao.PromotionRepository;
import com.pms.model.Promotion;
import com.pms.model.orderDetails;

@Service
public class PromotionService {
	@Autowired
	PromotionRepository promRepo;
	
	public Collection<Promotion> findAllProm() {
		ArrayList<Promotion> drug = new ArrayList<Promotion>();
		for (Promotion iterable_element : promRepo.findAll()) {
			drug.add(iterable_element);
		}
		return (Collection<Promotion>) drug;

	}

}
