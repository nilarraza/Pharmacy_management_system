package com.pms.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.pms.dao.PresDrugsRepository;
import com.pms.model.PresDrugs;

import antlr.collections.List;

@Service
public class DrugService {

	@Autowired
	private PresDrugsRepository presDrugsRepository;

	public Collection<PresDrugs> findAllPresDrugs() {
		ArrayList<PresDrugs> drug = new ArrayList<PresDrugs>();
		for (PresDrugs iterable_element : presDrugsRepository.findAll()) {
			drug.add(iterable_element);
		}
		return (Collection<PresDrugs>) drug;

	}

	public Collection<PresDrugs> findByName(String name) {
		ArrayList<PresDrugs> drug = new ArrayList<PresDrugs>();
		for (PresDrugs iterable_element : presDrugsRepository.findByNameLike("%"+name+"%")) {
			drug.add(iterable_element);
		}

		return (Collection<PresDrugs>) drug;

	}

}
