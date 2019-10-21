package com.pms.model;

import java.sql.Date;

import javax.persistence.Entity;

@Entity
public class Doctor  extends Person{
	private String slmcNo;
	
	
	public Doctor() {
		super();
	}
	

	public Doctor(int user_id, String contactNo, String email, String nic, Date dob, String username, String password,
			String role, String slmcNo) {
		super.user_id = user_id;
		super.contactNo = contactNo;
		super.email = email;
		super.nic = nic;
		super.dob = dob;
		super.username = username;
		super.password = password;
		super.role = role;
		this.slmcNo = slmcNo;
	}


	public String getSlmcNo() {
		return slmcNo;
	}

	public void setSlmcNo(String slmcNo) {
		this.slmcNo = slmcNo;
	}

	
	
	@Override
	public String toString() {
		return "Doctor [slmcNo=" + slmcNo + "]";
	}

}
