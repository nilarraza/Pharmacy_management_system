package com.pms.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pms.Util.EmailUtil;
import com.pms.dao.FeedbackRepository;
import com.pms.dao.PersonRepository;
import com.pms.model.Feedback;
import com.pms.model.Person;
import com.pms.service.FeedbackService;
import com.pms.service.PersonUserDetails;

@Controller
public class FeedbackController {
	@Autowired 
	FeedbackRepository feedRepo;
	@Autowired
	FeedbackService feedService;
	@Autowired
	PersonRepository personRepo;
	
	@Autowired
	EmailUtil email;
	
	@RequestMapping("/sendFeedback")
	public String showDrOrders(Feedback feedback,Authentication authentication) {
		java.lang.Object principal = authentication.getPrincipal();
	
		int userId = 0;

		if (principal instanceof UserDetails) {
			userId = ((PersonUserDetails) principal).getPerson().getUser_id();
		}
		feedback.setUser_id(userId);
		//String txt=feedback.getFeedback();
		
		
		
		feedRepo.save(feedback);
		
		return "redirect:/success";
	}
	
	
	@RequestMapping("/ShowFeedback")
	public String ShowFeedback( ModelMap modelmap) {
		modelmap.addAttribute("feedback",feedService.findAllFeedback());
		return "FeedbacksAdmin.jsp";
		
	}
	
	@RequestMapping("/sendReply")
	public String sendReply( int id, ModelMap modelmap) {
		Person person=personRepo.findById(id).get();
		String mail=person.getEmail();
		modelmap.addAttribute("replymail",mail);
		return "replyFeedback.jsp";
		
	}
	
	
	@RequestMapping("/sendReplyFeedback")
	public String sendReplyFeedback( @RequestParam("mail") String mail, @RequestParam("subject") String subject,@RequestParam("content") String content) {
		
		email.sendEmail(mail,subject,content);
				

		return "redirect:/ShowFeedback";
	}
	

}
