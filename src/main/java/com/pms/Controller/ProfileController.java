package com.pms.Controller;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.pms.dao.PharmasistRepository;
import com.pms.dao.ProfileImgRepository;
import com.pms.model.NonPresDrugs;
import com.pms.model.Person;
import com.pms.model.Pharmasist;
import com.pms.model.PresDrugs;
import com.pms.model.ProfileImg;
import com.pms.service.PersonUserDetails;

@Controller
public class ProfileController {
	
	@Autowired
	ProfileImgRepository ProfileImgRepo;
	
	@Autowired
	PharmasistRepository pharmaRepo;
	
	
	@GetMapping("/UserProfile")
	public String UserProfile(Authentication authentication,ModelMap modelmap) {
		java.lang.Object principal= authentication.getPrincipal();
		int userId=0;
		String username = null;
		String email = null;
		String contactno = null;
		if (principal instanceof UserDetails) {		
			  userId= ((PersonUserDetails)principal).getPerson().getUser_id();
			  username= ((PersonUserDetails)principal).getPerson().getUsername();
			   email= ((PersonUserDetails)principal).getPerson().getEmail();
			    contactno = ((PersonUserDetails)principal).getPerson().getContactNo();
		 }
		
//		if(findpic(authentication)==true) {
//		 modelmap.addAttribute("profileimg",ProfileImgRepo.findById(userId).get());
//		 modelmap.addAttribute("username",username);
//		 modelmap.addAttribute("email",email);
//		 modelmap.addAttribute("contactno",contactno);
//		}
//		else {
//			 modelmap.addAttribute("username",username);
//			 modelmap.addAttribute("email",email);
//			 modelmap.addAttribute("contactno",contactno);
//		}
		
		 modelmap.addAttribute("profileimg",ProfileImgRepo.findById(userId).get());
		 modelmap.addAttribute("username",username);
		 modelmap.addAttribute("email",email);
		 modelmap.addAttribute("contactno",contactno);
		
		return "UserProfile.jsp";

	}
	
	public Boolean findpic(Authentication authentication) {
		java.lang.Object principal= authentication.getPrincipal();
		int userId=0;
		if (principal instanceof UserDetails) {		
			  userId= ((PersonUserDetails)principal).getPerson().getUser_id();
		}
		
		if(ProfileImgRepo.findById(userId).get() != null) {
			return true;
		}else {
	
		return false;
		}
	}
	
	
	
	
//	public int getCurrentUserId(Authentication authentication) {
//		java.lang.Object principal= authentication.getPrincipal();
//		int userId=0;
//		if (principal instanceof UserDetails) {
//			
//			  userId= ((PersonUserDetails)principal).getPerson().getUser_id();
//			 
//			
//		 }
		
	
	

	
	
	
	
	
	
	
	@RequestMapping(value = "/addUserImg", method = RequestMethod.POST)
	public String addUserImg(ProfileImg one, @RequestParam("img") MultipartFile multipartfile,Authentication authentication,ModelMap modelmap) throws Exception {

		int userId=0;
		java.lang.Object principal= authentication.getPrincipal();
		
		if (principal instanceof UserDetails) {
			 String username = ((PersonUserDetails)principal).getPerson().getUsername();
			  userId= ((PersonUserDetails)principal).getPerson().getUser_id();
			 
			 modelmap.addAttribute("username",username );
		 }

		one.setId(userId);;		
		
		String urlpath = saveProfileImage(multipartfile);

		one.setUrl(urlpath);

		ProfileImgRepo.save(one);


		return "/UserProfile.jsp";
		
	}

	public String saveProfileImage(@RequestParam("img") MultipartFile multipartfile) throws Exception {

		byte[] bytes = multipartfile.getBytes();
		java.nio.file.Path path = Paths
				.get("C:\\spring Workspace\\PMS\\src\\main\\webapp\\ProfileImg\\" + multipartfile.getOriginalFilename());
		Files.write(path, bytes);

		return multipartfile.getOriginalFilename();
	}
	@RequestMapping(value = "/editPharmasist")
	public String editPharmasist(Authentication authentication,ModelMap modelmap){
		
		java.lang.Object principal= authentication.getPrincipal();
		Person user = null;
//		String username = null;
//		String email = null;
//		String contactno = null;
//		String nic = null;
//		Date dob = null;
		
		if (principal instanceof UserDetails) {		
			user= ((PersonUserDetails)principal).getPerson();
//			  username= ((PersonUserDetails)principal).getPerson().getUsername();
//			   email= ((PersonUserDetails)principal).getPerson().getEmail();
//			    contactno = ((PersonUserDetails)principal).getPerson().getContactNo();
//			    nic = ((PersonUserDetails)principal).getPerson().getNic();
//			    dob = ((PersonUserDetails)principal).getPerson().getDob();
//			  
		 }
		
		 modelmap.addAttribute("user",user);
//		 modelmap.addAttribute("email",email);
//		 modelmap.addAttribute("contactno",contactno);
		

		

		return "editPharmasist.jsp";
	}
	
	@RequestMapping("/updatePharmasist")
	public String addPharmasist(Pharmasist pharma) {
		pharmaRepo.save(pharma);
		return "redirect:/UserProfile";
	}
	
	
	


}
