package com.pms.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pms.dao.CustomerRepository;
import com.pms.dao.DoctorRepository;
import com.pms.dao.PersonRepository;
import com.pms.dao.PharmasistRepository;
import com.pms.model.Customer;
import com.pms.model.Doctor;
import com.pms.model.Person;
import com.pms.model.Pharmasist;

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
	private BCryptPasswordEncoder passwordEncoder;

	@RequestMapping("/addCustomer")
	public String addUser(Customer customer) {
		customer.setRole("customer");
		String pwd=customer.getPassword();
		String encryptpwd=passwordEncoder.encode(pwd);
		customer.setPassword(encryptpwd);
		perRepo.save(customer);
		cusRepo.save(customer);
		return "custRegister.jsp";
	}
	
	@RequestMapping("/addPharmasist")
	public String addPharmasist(Pharmasist pharma) {
		pharma.setRole("Pharmasist");
		String pwd=pharma.getPassword();
		String encryptpwd=passwordEncoder.encode(pwd);
		pharma.setPassword(encryptpwd);
		perRepo.save(pharma);
		pharmaRepo.save(pharma);
		return "pharmRegister.jsp";
	}
	
	@RequestMapping("/adddoctor")
	public String addDoctor(Doctor doctor) {
		doctor.setRole("doctor");
		String pwd=doctor.getPassword();
		String encryptpwd=passwordEncoder.encode(pwd);
		doctor.setPassword(encryptpwd);
		perRepo.save(doctor);
		docRepo.save(doctor);
		return "docRegister.jsp";
	}

	@RequestMapping("/addPerson")
	public String addPersor(Person person) {
		String pwd=person.getPassword();
		String encryptpwd=passwordEncoder.encode(pwd);
		person.setPassword(encryptpwd);
		perRepo.save(person);
		return "custRegister.jsp";
	}
	
	

}
