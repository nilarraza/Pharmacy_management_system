package com.pms.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.dao.DrugRepository;
import com.pms.dao.ShoppingCardRepository;
import com.pms.dao.checkTotalRepository;
import com.pms.model.Drugs;
import com.pms.model.PresDrugs;
import com.pms.model.ShoppingCard;
import com.pms.model.checkTotal;

@Service
public class ShoppingCardService {
	@Autowired
	ShoppingCardRepository shopCardRepo;
	@Autowired
	DrugRepository drugRepo;
	@Autowired
	checkTotalRepository checkRepo;
	
	public Collection<checkTotal> findAllDrugs() {
		ArrayList<checkTotal> drug = new ArrayList<checkTotal>();
		for (checkTotal iterable_element : checkRepo.findAll()) {
			drug.add(iterable_element);
		}
		return (Collection<checkTotal>) drug;

	}
	
	
	
	public Collection<checkTotal> findAllDrugsPrice() {
		ArrayList<checkTotal> drug = new ArrayList<checkTotal>();
		for (checkTotal iterable_element : checkRepo.findAll()) {
			drug.add(iterable_element);
		}
		return (Collection<checkTotal>) drug;

	}


}
