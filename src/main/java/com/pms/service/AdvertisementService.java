package com.pms.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.pms.dao.AdvertismentRepository;
import com.pms.model.Advertisement;
import com.pms.model.PresDrugs;

@Service
public class AdvertisementService {
	@Autowired
	AdvertismentRepository advRepo;
	
	
	public Collection<Advertisement> findAllPromotions() {
		
		ArrayList<Advertisement> drug = new ArrayList<Advertisement>();
		for (Advertisement iterable_element : advRepo.findAll()) {
			drug.add(iterable_element);
		}
		return (Collection<Advertisement>) drug;

	}
	

}
