package com.pms.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pms.dao.NonPresDrugsRepository;
import com.pms.dao.PresDrugsRepository;
import com.pms.model.Customer;
import com.pms.model.Drugs;
import com.pms.model.NonPresDrugs;
import com.pms.model.PresDrugs;

@RestController
@RequestMapping("/Drugs")
public class DrugsController {
	@Autowired
	PresDrugsRepository presdrugRepo;
	@Autowired
	NonPresDrugsRepository nonpresdrugRepo;
	
	
	@PostMapping("/addDrugs")
	public String addDrugs(PresDrugs presdrugs) {
		PresDrugs one=new PresDrugs(0, presdrugs.getName(),presdrugs.getDosage(),presdrugs.getDescription(),presdrugs.getPrice(),presdrugs.getAvailability(),presdrugs.getGenericName());
		
		presdrugRepo.save(one);
		System.out.print(presdrugs);
		return "drugs succesfully added";
	}

}
