package com.pms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ShoppingCard {
	@Id
	@GeneratedValue
	public int id;
	public String Pname;
	public String price;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPname() {
		return Pname;
	}
	public void setPname(String pname) {
		Pname = pname;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public ShoppingCard(int id, String pname, String price) {
		super();
		this.id = id;
		Pname = pname;
		this.price = price;
	}
	public ShoppingCard() {
		super();
	}
	@Override
	public String toString() {
		return "ShoppingCard [id=" + id + ", Pname=" + Pname + ", price=" + price + "]";
	}
	
	

}
