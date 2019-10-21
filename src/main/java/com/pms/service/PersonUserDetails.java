package com.pms.service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.pms.model.Person;

public class PersonUserDetails implements UserDetails{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3260566258689368559L;
	/**
	 * 
	 */
	
	private Person person;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
		// TODO Auto-generated method stub
		
	}
	

	public Person getPerson() {
		return person;
	}


	public void setPerson(Person person) {
		this.person = person;
	}


	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return person.getPassword();
	}

	@Override
	public  String getUsername() {
		// TODO Auto-generated method stub
		return person.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	

}
