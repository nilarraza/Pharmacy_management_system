package com.pms.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pms.dao.PersonRepository;
import com.pms.service.DrugService;
import com.pms.service.PersonUserDetails;

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
	public String successRoute(Authentication authentication,ModelMap modelmap) {
		
		
		 java.lang.Object principal= authentication.getPrincipal();
		 
		 if (principal instanceof UserDetails) {
			 String role = ((PersonUserDetails)principal).getPerson().role;
			 String username = ((PersonUserDetails)principal).getPerson().getUsername();
			 modelmap.addAttribute("username",username );
			 
			 System.out.println(role);
			 
			 if(role.equals("customer")) {
				 return "Customer.jsp";
		         // redirect to Customer.html page
		    } else if(role.equals("admin")) {
		    	return "Admin.jsp";
		         // redirect indexUser.html page
		    } else if(role.equals("Pharmasist")){
		    	return "ShowDrugs.jsp";
		         // redirect to indexProfesor.html page
		    } else if(role.equals("doctor")){
		    	return "dashBoard.jsp";
		    }else {
		    	System.out.println("Bad login");	
		    	}
			 
			 
		 }
		return "Bad login";
	}		 


}
	
