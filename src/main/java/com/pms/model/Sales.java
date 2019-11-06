package com.pms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Sales {
	
	@Id
	@GeneratedValue
	public int id;
	public int pid;
	public String price;
	

	
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public Sales(int id, int pid, String price) {
		super();
		this.id = id;
		this.pid = pid;
		this.price = price;
	}
	public Sales() {
		super();
	}
	@Override
	public String toString() {
		return "Sales [id=" + id + ", pid=" + pid + ", price=" + price + "]";
	}
	
	
	

	
	


}
