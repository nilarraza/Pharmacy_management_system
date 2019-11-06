package com.pms.Controller;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.pms.Util.EmailUtil;
import com.pms.dao.DrOrderRepository;
import com.pms.dao.OrderRepository;
import com.pms.dao.PersonRepository;
import com.pms.model.DrOrderDetails;
import com.pms.model.Person;
import com.pms.model.orderDetails;
import com.pms.service.PersonUserDetails;
import com.pms.service.orderService;

@Controller
public class OrderController {
	@Autowired
	OrderRepository orderRepo;

	@Autowired
	EmailUtil email;
	@Autowired
	orderService orderServ;
	@Autowired
	PersonRepository presonRepo;
	@Autowired
	DrOrderRepository drorderRepo;

	@RequestMapping("/uploadP")
	public String uploadP(Authentication authentication, ModelMap modelmap) {
		java.lang.Object principal = authentication.getPrincipal();
		String name = null;
		if (principal instanceof UserDetails) {

			name = ((PersonUserDetails) principal).getPerson().getUsername();

		}

		modelmap.addAttribute("username", name);
		return "uploadPres.jsp";
	}

	@RequestMapping("/uploadD")
	public String uploadD(Authentication authentication, ModelMap modelmap) {
		java.lang.Object principal = authentication.getPrincipal();
		String name = null;
		if (principal instanceof UserDetails) {

			name = ((PersonUserDetails) principal).getPerson().getUsername();

		}

		modelmap.addAttribute("username", name);
		return "orderDorctor.jsp";
	}

	@RequestMapping("/uploadPresOrder")
	public String uploadPresOrder(orderDetails order, @RequestParam("img") MultipartFile multipartfile,
			Authentication authentication) throws Exception {
		int userId = 0;
		String mail = null;
		java.lang.Object principal = authentication.getPrincipal();

		if (principal instanceof UserDetails) {

			userId = ((PersonUserDetails) principal).getPerson().getUser_id();
			mail = ((PersonUserDetails) principal).getPerson().getEmail();

		}

		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();

		order.setOrderDate(date);
		order.setOrderTime(time);
		System.out.println(userId);
		order.setUser(userId);

		String urlpath = savePresImage(multipartfile);

		order.setPath(urlpath);

		email.sendEmail(mail, "Order Confirmation", "Order succesfully placed.Our staff will conform the order soon.");
		orderRepo.save(order);

		return "uploadPres.jsp";
	}

	public String savePresImage(@RequestParam("img") MultipartFile multipartfile) throws Exception {

		byte[] bytes = multipartfile.getBytes();
		java.nio.file.Path path = Paths
				.get("C:\\spring Workspace\\PMS\\src\\main\\webapp\\PresImg\\" + multipartfile.getOriginalFilename());
		Files.write(path, bytes);

		return multipartfile.getOriginalFilename();
	}

	@RequestMapping("/showOrders")
	public String showMycard(ModelMap modelmap) {

		System.out.println(orderServ.findAllOrders());
		modelmap.addAttribute("drugs", orderServ.findAllOrders());
		return "orderPh.jsp";
	}
	
	@RequestMapping("/showDrOrders")
	public String showDrOrders(ModelMap modelmap) {

		System.out.println(orderServ.findAllOrders());
		modelmap.addAttribute("drugs", orderServ.findAllDrOrders());
		return "orderDr.jsp";
	}

	@RequestMapping("/sendConfirmationCr")
	public String sendConfirmation(int id,ModelMap modelmap) {
		Person person = presonRepo.findById(id).get();
		String mail = person.getEmail();
//		email.sendEmail(mail, "Order Confirmation",
//				"Your order is confirmed.Our delivery person will contact you soon");
		modelmap.addAttribute("mail", mail);
		return "OrderConfirmationMail.jsp";
	}
	
	@RequestMapping("/sendCancelCr")
	public String sendCancelCr(int ido,int id,ModelMap modelmap) {
		Person person = presonRepo.findById(id).get();
		String mail = person.getEmail();
		orderRepo.deleteById(ido);
//		email.sendEmail(mail, "Order Confirmation",
//				"Your order is confirmed.Our delivery person will contact you soon");
		modelmap.addAttribute("mail", mail);
		return "OrderCancelMail.jsp";
	}
	
	@RequestMapping("/sendConfirmationMail")
	public String sendConfirmationMail( @RequestParam("mail") String mail, @RequestParam("subject") String subject,@RequestParam("content") String content) {
		
		email.sendEmail(mail,subject,content);
				

		return "redirect:/showOrders";
	}
	
	
	@RequestMapping("/sendCancelMail")
	public String sendCancelMail(String mail,String subject,String content) {
		
		email.sendEmail(mail,subject,content);
				

		return "redirect:/showOrders";
	}
	@RequestMapping("/sendDrConfirmation")
	public String sendDrConfirmation(int id) {
		Person person = presonRepo.findById(id).get();
		String mail = person.getEmail();
		email.sendEmail(mail, "Order Confirmation",
				"Your order is confirmed.Our delivery person will contact you soon");

		return "redirect:/showDrOrders";
	}

	@RequestMapping("/uploadDrOrder")
	public String uploadDrOrder(DrOrderDetails order, Authentication authentication) throws Exception {
		int userId = 0;
		String mail = null;
		java.lang.Object principal = authentication.getPrincipal();

		if (principal instanceof UserDetails) {

			userId = ((PersonUserDetails) principal).getPerson().getUser_id();
			mail = ((PersonUserDetails) principal).getPerson().getEmail();

		}

		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();

		order.setOrderDate(date);
		order.setOrderTime(time);
		order.setUser(userId);
		String cmail = order.getEmail();

		email.sendEmail(mail, "Order Confirmation", "Order succesfully placed.Our staff will conform the order soon.");
		drorderRepo.save(order);

		email.sendEmail(cmail, "Order Confirmation", "Order succesfully placed.Our staff will conform the order soon.");
		drorderRepo.save(order);

		return "orderDorctor.jsp";
	}
	
	@RequestMapping("/showOrdersDr")
	public String showOrdersDr(ModelMap modelmap,Authentication authentication) {
		
		java.lang.Object principal = authentication.getPrincipal();
		int userId=0;
		if (principal instanceof UserDetails) {

			userId = ((PersonUserDetails) principal).getPerson().getUser_id();			
		}
		modelmap.addAttribute("drugs",orderServ.findByIdDrOrders(userId) );
		return "drOrders.jsp";
	}
	
	@RequestMapping("/showOrdersCr")
	public String showOrdersCr(ModelMap modelmap,Authentication authentication) {
		
		java.lang.Object principal = authentication.getPrincipal();
		int userId=0;
		if (principal instanceof UserDetails) {

			userId = ((PersonUserDetails) principal).getPerson().getUser_id();			
		}
		modelmap.addAttribute("drugs",orderServ.findByIdCrOrders(userId));
		
		return "custOrders.jsp";
	}
	
	@RequestMapping("/showOrdersAd")
	public String showOrdersAd(ModelMap modelmap) {

		System.out.println(orderServ.findAllOrders());
		modelmap.addAttribute("drugs", orderServ.findAllOrders());
		return "orderAdmin.jsp";
	}
	
	@RequestMapping("/showDrOrdersAd")
	public String showDrOrdersAd(ModelMap modelmap) {

		System.out.println(orderServ.findAllOrders());
		modelmap.addAttribute("drugs", orderServ.findAllDrOrders());
		return "orderDrAdmin.jsp";
	}
	
	
	

}
