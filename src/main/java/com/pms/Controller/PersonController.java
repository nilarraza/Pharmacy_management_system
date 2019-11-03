package com.pms.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pms.dao.CustomerRepository;
import com.pms.dao.DoctorRepository;
import com.pms.dao.PersonRepository;
import com.pms.dao.PharmasistRepository;
import com.pms.model.Customer;
import com.pms.model.Doctor;
import com.pms.model.Person;
import com.pms.model.Pharmasist;
import com.pms.service.PersonService;

@Controller
public class PersonController {
	@Autowired
	CustomerRepository cusRepo;
	@Autowired
	PersonRepository perRepo;
	@Autowired
	DoctorRepository docRepo;
	@Autowired
	PharmasistRepository pharmaRepo;
	@Autowired
	PersonService personService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@RequestMapping("/addCustomer")
	public String addUser(Customer customer) {
		customer.setRole("customer");
		String pwd = customer.getPassword();
		String encryptpwd = passwordEncoder.encode(pwd);
		customer.setPassword(encryptpwd);
		perRepo.save(customer);
		cusRepo.save(customer);
		return "custRegister.jsp";
	}

	@RequestMapping("/updateResetCustomer")
	public String updateUser(Customer customer) {
		customer.setRole("customer");
		String pwd = customer.getPassword();
		String encryptpwd = passwordEncoder.encode(pwd);
		customer.setPassword(encryptpwd);
		perRepo.save(customer);
		cusRepo.save(customer);
		return "redirect:/login";
	}

	@RequestMapping("/addPharmasist")
	public String addPharmasist(Pharmasist pharma) {
		pharma.setRole("Pharmasist");
		String pwd = pharma.getPassword();
		String encryptpwd = passwordEncoder.encode(pwd);
		pharma.setPassword(encryptpwd);

		perRepo.save(pharma);
		pharmaRepo.save(pharma);
		return "pharmRegister.jsp";
	}

	@RequestMapping("/updateResetPharmasist")
	public String updatePharmasist(Pharmasist pharma) {
		pharma.setRole("Pharmasist");
		String pwd = pharma.getPassword();
		String encryptpwd = passwordEncoder.encode(pwd);
		pharma.setPassword(encryptpwd);
		perRepo.save(pharma);
		pharmaRepo.save(pharma);
		return "redirect:/login";
	}

	@RequestMapping("/adddoctor")
	public String addDoctor(Doctor doctor) {
		doctor.setRole("doctor");
		String pwd = doctor.getPassword();
		String encryptpwd = passwordEncoder.encode(pwd);
		doctor.setPassword(encryptpwd);
		perRepo.save(doctor);
		docRepo.save(doctor);
		return "docRegister.jsp";
	}

	@RequestMapping("/updateResetDoctor")
	public String updateDoctor(Doctor doctor) {
		doctor.setRole("doctor");
		String pwd = doctor.getPassword();
		String encryptpwd = passwordEncoder.encode(pwd);
		doctor.setPassword(encryptpwd);
		perRepo.save(doctor);
		docRepo.save(doctor);
		return "redirect:/login";
	}

	@RequestMapping("/addPerson")
	public String addPersor(Person person) {
		String pwd = person.getPassword();
		String encryptpwd = passwordEncoder.encode(pwd);
		person.setPassword(encryptpwd);
		perRepo.save(person);
		return "custRegister.jsp";
	}

	@GetMapping("/listCustomers")
	public String showCustomer(HttpServletRequest req) {
		req.setAttribute("person", personService.findAllCustomers());

		return "Admin.jsp";

	}

	@GetMapping("/listPharmasist")
	public String showPharmasist(HttpServletRequest req) {
		req.setAttribute("person", personService.findAllPharmasist());

		return "Admin.jsp";

	}

	@GetMapping("/listDoctors")
	public String showDoctors(HttpServletRequest req) {
		req.setAttribute("person", personService.findAllDoctors());

		return "Admin.jsp";

	}

	@RequestMapping("/searchPerson")
	public String searchDrug(@RequestParam("search") String name, ModelMap modelmap) {
		modelmap.addAttribute("person", personService.findByName(name));
		return "Admin.jsp";

	}

	@RequestMapping("/deletePerson")
	public String deletePerson(int id, ModelMap modelmap) {
		perRepo.deleteById(id);
		modelmap.addAttribute("msg", "Succesfully deleted the person.");
		return "Admin.jsp";

	}

	@RequestMapping("/updatePharmasist")
	public String addPharmasistup(Pharmasist pharma) {
		pharmaRepo.save(pharma);
		return "redirect:/UserProfile";
	}

	@RequestMapping("/updateCustomer")
	public String addCustomerup(Customer cust) {
		cusRepo.save(cust);
		return "redirect:/UserProfile";
	}

	@RequestMapping("/updateDoctor")
	public String addDoctorup(Doctor doc) {
		docRepo.save(doc);
		return "redirect:/UserProfile";
	}

}
