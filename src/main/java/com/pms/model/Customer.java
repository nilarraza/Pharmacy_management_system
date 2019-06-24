package com.pms.model;

import java.sql.Date;

import javax.persistence.Entity;
@Entity
public class Customer extends Person {
	
	private String role;

	public Customer( String role,int user_id, String contactNo, String email, String nic, Date dob, String username,
			String password) {
		super();
		super.user_id = user_id;
		super.contactNo = contactNo;
		super.email = email;
		super.nic = nic;
		super.dob = dob;
		super.username = username;
		super.password = password;
		this.role=role;
		
	}
	

	public Customer() {
		super();
	}


	@Override
	public String toString() {
		return "Customer [role=" + role + "]";
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
