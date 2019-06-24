package com.pms.model;

import java.sql.Date;

import javax.persistence.Entity;

@Entity
public class Pharmasist extends Person {

	private String pharmaRegNo;
	private String role;

	public Pharmasist() {
		super();
	}

	public Pharmasist( String role,int user_id,String pharmaRegNo, String contactNo,String slmcNo, String email, String nic, Date dob, String username,
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
		this.pharmaRegNo=pharmaRegNo;
	}

	public String getPharmaRegNo() {
		return pharmaRegNo;
	}

	public void setPharmaRegNo(String pharmaRegNo) {
		this.pharmaRegNo = pharmaRegNo;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
