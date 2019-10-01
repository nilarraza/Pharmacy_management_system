package com.pms.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pms.dao.PersonRepository;
import com.pms.model.Person;
import com.pms.service.DrugService;

@Controller
public class ApplicationController {
	
	@Autowired
	DrugService drugService;
	@Autowired
	PersonRepository presonRepo;

	@RequestMapping("/dashBoard")
	public String userProcess() {
		return "dashBoard.jsp";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {

		if (error != null)
           model.addAttribute("errorMsg", "Your username and password are invalid.");

//       if (logout != null)
//           model.addAttribute("msg", "You have been logged out successfully.");

		
		return "login.jsp";
	}
	
	@GetMapping("/PharShowPresDrug")
	public String PharShowPresDrugs(HttpServletRequest req) {
		req.setAttribute("drugs",drugService.findAllPresDrugs());
		return "ShowDrugs.jsp";
		
	}
	
	@GetMapping("/PharShowNonPresDrug")
	public String PharShowNonPresDrugs(HttpServletRequest req) {
		req.setAttribute("drugs",drugService.findAllNonPresDrugs());
		return "ShowDrugs.jsp";
		
	}
	
	@GetMapping("/CustShowPresDrug")
	public String CustShowPresDrugs(HttpServletRequest req) {
		req.setAttribute("drugs",drugService.findAllPresDrugs());
		return "Customer.jsp";
		
	}
	
	@GetMapping("/CustShowNonPresDrug")
	public String CustShowNonPresDrugs(HttpServletRequest req) {
		req.setAttribute("drugs",drugService.findAllNonPresDrugs());
		return "Customer.jsp";
		
	}
	
	@GetMapping("/success")
	public String LoginSuccess(Person person ) {
		
		System.out.println(person);
		return "Customer.jsp";
		
	}
	
	
	
	
//	@RequestMapping(value = "/logout", method = RequestMethod.GET)
//	public String logout(Model model, String error, String logout) {
//
//
//       if (logout != null)
//           model.addAttribute("msg", "You have been logged out successfully.");
//
//		
//		return "login.jsp";
//	}

}
