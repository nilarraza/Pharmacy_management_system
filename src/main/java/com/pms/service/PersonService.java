package com.pms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pms.dao.PersonRepository;
import com.pms.model.Person;
@Service
public class PersonService implements UserDetailsService {
	@Autowired
	private PersonRepository personRepo;
	
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

}
