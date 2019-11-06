package com.pms.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pms.dao.PromotionRepository;
import com.pms.model.Promotion;

@Controller
public class PromotionController {
	@Autowired
	PromotionRepository promRepo;
	
	@RequestMapping("/addPromotion")	
	public String addPromotion(Promotion prom) {
		promRepo.save(prom);
		
		
		return "Admin.jsp";

	}
	
	
	@RequestMapping("/deletePromotion")	
	public String deletePromotion() {
		promRepo.deleteAll();
		
		
		return "Admin.jsp";

	}

}
