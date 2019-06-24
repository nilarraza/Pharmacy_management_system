package com.pms.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Person {
	@Id
	@GeneratedValue
	protected int user_id;
	protected String contactNo;
	protected String email;
	protected String nic;
	protected Date dob;
	protected String username;
	protected String password;

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNic() {
		return nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Person [contactNo=" + contactNo + ", email=" + email + ", nic=" + nic + ", dob=" + dob + ", username="
				+ username + ", password=" + password + "]";
	}

	public Person(int user_id, String contactNo, String email, String nic, Date dob, String username, String password) {
		super();
		this.user_id = user_id;
		this.contactNo = contactNo;
		this.email = email;
		this.nic = nic;
		this.dob = dob;
		this.username = username;
		this.password = password;
	}

	public Person() {
		
	}

	

}
