package com.pms.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.dao.DrugRepository;
import com.pms.dao.NonPresDrugsRepository;
import com.pms.dao.PresDrugsRepository;
import com.pms.model.Drugs;
import com.pms.model.NonPresDrugs;
import com.pms.model.PresDrugs;

import antlr.collections.List;

@Service
public class DrugService {
	@Autowired
	DrugRepository drugRepo;

	@Autowired
	private PresDrugsRepository presDrugsRepository;
	@Autowired
	private NonPresDrugsRepository nonPresDrugsRepository;

	public Collection<PresDrugs> findAllPresDrugs() {
		ArrayList<PresDrugs> drug = new ArrayList<PresDrugs>();
		for (PresDrugs iterable_element : presDrugsRepository.findAll()) {
			drug.add(iterable_element);
		}
		return (Collection<PresDrugs>) drug;

	}
	
	public Collection<NonPresDrugs> findAllNonPresDrugs() {
		ArrayList<NonPresDrugs> drug = new ArrayList<NonPresDrugs>();
		for (NonPresDrugs iterable_element : nonPresDrugsRepository.findAll()) {
			drug.add(iterable_element);
		}
		return (Collection<NonPresDrugs>) drug;

	}


	public Collection<Drugs> findByName(String name) {
		ArrayList<Drugs> drug = new ArrayList<Drugs>();
		for (Drugs iterable_element : drugRepo.findByNameLike("%"+name+"%")) {
			drug.add(iterable_element);
		}

		return (Collection<Drugs>) drug;

	}

}
