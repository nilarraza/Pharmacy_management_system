package com.pms.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class DrOrderDetails {
	@Id
	@GeneratedValue
	public int orderId;
	public int user;
	public String name;
	public String contactNo;
	public String address;
	public String email;
	public String prescription;
	public LocalDate orderDate;
	public LocalTime orderTime;
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getUser() {
		return user;
	}
	public void setUser(int user) {
		this.user = user;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPrescription() {
		return prescription;
	}
	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public LocalTime getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(LocalTime orderTime) {
		this.orderTime = orderTime;
	}
	public DrOrderDetails(int orderId, int user, String name, String contactNo, String address, String email,
			String prescription, LocalDate orderDate, LocalTime orderTime) {
		super();
		this.orderId = orderId;
		this.user = user;
		this.name = name;
		this.contactNo = contactNo;
		this.address = address;
		this.email = email;
		this.prescription = prescription;
		this.orderDate = orderDate;
		this.orderTime = orderTime;
	}
	public DrOrderDetails() {
		super();
	}
	
	@Override
	public String toString() {
		return "DrOrderDetails [orderId=" + orderId + ", user=" + user + ", name=" + name + ", contactNo=" + contactNo
				+ ", address=" + address + ", email=" + email + ", prescription=" + prescription + ", orderDate="
				+ orderDate + ", orderTime=" + orderTime + "]";
	}
	
	

}
