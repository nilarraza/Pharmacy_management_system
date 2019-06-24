package com.pms.model;

import java.sql.Date;

import javax.persistence.Entity;

@Entity
public class Doctor  extends Person{
	private String slmcNo;
	private String role;
	
	public Doctor() {
		super();
	}
	public Doctor( String role,int user_id, String contactNo,String slmcNo, String email, String nic, Date dob, String username,
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
		this.slmcNo=slmcNo;
		
	}

	public String getSlmcNo() {
		return slmcNo;
	}

	public void setSlmcNo(String slmcNo) {
		this.slmcNo = slmcNo;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Doctor [slmcNo=" + slmcNo + ", role=" + role + "]";
	}

}
