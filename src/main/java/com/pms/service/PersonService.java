package com.pms.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pms.dao.CustomerRepository;
import com.pms.dao.DoctorRepository;
import com.pms.dao.PersonRepository;
import com.pms.dao.PharmasistRepository;
import com.pms.model.Customer;
import com.pms.model.Doctor;
import com.pms.model.Person;
import com.pms.model.Pharmasist;
import com.pms.model.PresDrugs;
@Service
public class PersonService implements UserDetailsService {
	@Autowired
	private PersonRepository personRepo;
	
	@Autowired
	CustomerRepository customerRepo;
	@Autowired
	PharmasistRepository pharmasistRepo;
	@Autowired
	DoctorRepository doctorRpo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Person person=personRepo.findByUsername(username);
		PersonUserDetails userDetails=null;
		if(person!=null) {
			userDetails=new PersonUserDetails();
			userDetails.setPerson(person);
		}else {
			throw new UsernameNotFoundException("user not exist with name"+username);
		}
		
		return userDetails;
	}

	public  Collection<Customer> findAllCustomers() {
		ArrayList<Customer> customer = new ArrayList<Customer>();
		for (Customer iterable_element : customerRepo.findAll()) {
			customer.add(iterable_element);	
					
	}
		return (Collection<Customer>) customer;
	

	}

	public Collection<Pharmasist> findAllPharmasist() {
		ArrayList<Pharmasist> pharmasist = new ArrayList<Pharmasist>();
		for (Pharmasist iterable_element : pharmasistRepo.findAll()) {
			pharmasist.add(iterable_element);	
		
	}
		return (Collection<Pharmasist>) pharmasist;
	}

	public Collection<Doctor> findAllDoctors() {
		ArrayList<Doctor> doctor = new ArrayList<Doctor>();
		for (Doctor iterable_element : doctorRpo.findAll()) {
			doctor.add(iterable_element);	
		
	}
		return (Collection<Doctor>) doctor;
	}

	public Collection<Person> findByName(String name) {
		ArrayList<Person> person = new ArrayList<Person>();
		for (Person iterable_element : personRepo.findByUsernameLike("%"+name+"%")) {
			person.add(iterable_element);	
		// TODO Auto-generated method stub
		
	}
		return (Collection<Person>) person;
	}
	

	

}
