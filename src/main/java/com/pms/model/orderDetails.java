package com.pms.model;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class orderDetails {
	
	
	
	@Id
	@GeneratedValue
	public int orderId;
	public int user;
	public String name;
	public String path;
	public String contactNo;
	public String address;
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
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
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
	public orderDetails(int orderId, int user, String name, String path, String contactNo, String address,
			LocalDate orderDate, LocalTime orderTime) {
		super();
		this.orderId = orderId;
		this.user = user;
		this.name = name;
		this.path = path;
		this.contactNo = contactNo;
		this.address = address;
		this.orderDate = orderDate;
		this.orderTime = orderTime;
	}
	public orderDetails() {
		super();
	}
	@Override
	public String toString() {
		return "orderDetails [orderId=" + orderId + ", user=" + user + ", name=" + name + ", path=" + path
				+ ", contactNo=" + contactNo + ", address=" + address + ", orderDate=" + orderDate + ", orderTime="
				+ orderTime + "]";
	}

	
	
	
}
