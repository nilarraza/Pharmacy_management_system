package com.pms.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.dao.FeedbackRepository;
import com.pms.model.Feedback;
import com.pms.model.PresDrugs;

@Service
public class FeedbackService {
	@Autowired
	FeedbackRepository feedRepo;
	
	public Collection<Feedback> findAllFeedback() {
		ArrayList<Feedback> drug = new ArrayList<Feedback>();
		for (Feedback iterable_element : feedRepo.findAll()) {
			drug.add(iterable_element);
		}
		return (Collection<Feedback>) drug;

	}

}
