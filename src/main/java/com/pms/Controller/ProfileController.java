package com.pms.Controller;

import java.nio.file.Files;
import java.nio.file.Paths;

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

import com.pms.Util.EmailUtil;
import com.pms.dao.CustomerRepository;
import com.pms.dao.DoctorRepository;
import com.pms.dao.PersonRepository;
import com.pms.dao.PharmasistRepository;
import com.pms.dao.ProfileImgRepository;
import com.pms.model.Person;
import com.pms.model.ProfileImg;
import com.pms.service.PersonUserDetails;

@Controller
public class ProfileController {

	@Autowired
	ProfileImgRepository ProfileImgRepo;

	@Autowired
	PharmasistRepository pharmaRepo;
	@Autowired
	PersonRepository personRepo;
	@Autowired
	CustomerRepository custRepo;
	@Autowired
	DoctorRepository docRepo;

	@Autowired
	EmailUtil email;

	@GetMapping("/UserProfile")
	public String UserProfile(Authentication authentication, ModelMap modelmap) {
		java.lang.Object principal = authentication.getPrincipal();
		int userId = 0;
		String username = null;
		String email = null;
		String contactno = null;
		if (principal instanceof UserDetails) {
			userId = ((PersonUserDetails) principal).getPerson().getUser_id();
			username = ((PersonUserDetails) principal).getPerson().getUsername();

			Person person = personRepo.findByUsername(username);

			System.out.println(contactno);

			if (ProfileImgRepo.findById(userId).isPresent() == true) {

				modelmap.addAttribute("profileimg", ProfileImgRepo.findById(userId).get());
				modelmap.addAttribute("username", person.getUsername());
				modelmap.addAttribute("email", person.getEmail());
				modelmap.addAttribute("contactno", person.getContactNo());
			} else {
				modelmap.addAttribute("username", person.getUsername());
				modelmap.addAttribute("email", person.getEmail());
				modelmap.addAttribute("contactno", person.getContactNo());
			}
		}

		return "UserProfile.jsp";

	}

	public Boolean findpic(Authentication authentication) {
		java.lang.Object principal = authentication.getPrincipal();
		int userId = 0;
		if (principal instanceof UserDetails) {
			userId = ((PersonUserDetails) principal).getPerson().getUser_id();
		}

		if (ProfileImgRepo.findById(userId).get() != null) {
			return true;
		} else {

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
	public String addUserImg(ProfileImg one, @RequestParam("img") MultipartFile multipartfile,
			Authentication authentication, ModelMap modelmap) throws Exception {

		int userId = 0;
		java.lang.Object principal = authentication.getPrincipal();

		if (principal instanceof UserDetails) {
			String username = ((PersonUserDetails) principal).getPerson().getUsername();
			userId = ((PersonUserDetails) principal).getPerson().getUser_id();

			modelmap.addAttribute("username", username);
		}

		one.setId(userId);

		String urlpath = saveProfileImage(multipartfile);

		one.setUrl(urlpath);

		ProfileImgRepo.save(one);

		return "redirect:/UserProfile";

	}

	public String saveProfileImage(@RequestParam("img") MultipartFile multipartfile) throws Exception {

		byte[] bytes = multipartfile.getBytes();
		java.nio.file.Path path = Paths.get(
				"C:\\spring Workspace\\PMS\\src\\main\\webapp\\ProfileImg\\" + multipartfile.getOriginalFilename());
		Files.write(path, bytes);

		return multipartfile.getOriginalFilename();
	}

	@RequestMapping(value = "/editPerson")
	public String editPharmasist(Authentication authentication, ModelMap modelmap) {

		java.lang.Object principal = authentication.getPrincipal();

		String username = ((PersonUserDetails) principal).getPerson().getUsername();

		if (principal instanceof UserDetails) {
			String role = ((PersonUserDetails) principal).getPerson().role;

			if (role.equals("customer")) {
				modelmap.addAttribute("user", personRepo.findByUsername(username));
				return "editCustomer.jsp";

			} else if (role.equals("Pharmasist")) {
				modelmap.addAttribute("user", personRepo.findByUsername(username));
				return "editPharmasist.jsp";

			} else if (role.equals("doctor")) {
				modelmap.addAttribute("user", personRepo.findByUsername(username));
				return "editDoctor.jsp";
			} else {
				return "Admin.jsp";
			}

		}
		return null;

	}

	@RequestMapping("/resetPasswordEmail")
	public String resetPassEmail(String username, ModelMap modelmap) {

		Person User = personRepo.findByUsername(username);

		String mail = User.getEmail();
		String name = User.getUsername();
		String resetUrl = "http://localhost:8080/resetPassword?username=" + name;

		email.sendEmail(mail, "reset Password", resetUrl);
//		 System.out.println(User.role);

		String msg = "Please click the reset link in your email. ";
		return "redirect:/login";
	}

	@RequestMapping("/resetPassword")
	public String resetPharmasist(String username, ModelMap modelmap) {
		Person User = personRepo.findByUsername(username);
		String role = User.role;

		if (role.equals("customer")) {
			modelmap.addAttribute("customer", User);
			return "resetCustomer.jsp";
		} else if (role.equals("Pharmasist")) {
			modelmap.addAttribute("Pharmasist", User);
			return "resetPharmasist.jsp";

		} else if (role.equals("doctor")) {
			modelmap.addAttribute("doctor", User);
			return "resetDoctor.jsp";
		} else {
			System.out.println("Username Not Found");
		}

		return null;

	}

}
