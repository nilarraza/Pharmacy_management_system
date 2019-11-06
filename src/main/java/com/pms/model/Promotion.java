package com.pms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Promotion {
	@Id
	@GeneratedValue
	public int id;
	public String Promocode;
	public String discountValue;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPromocode() {
		return Promocode;
	}
	public void setPromocode(String promocode) {
		Promocode = promocode;
	}
	public String getDiscountValue() {
		return discountValue;
	}
	public void setDiscountValue(String discountValue) {
		this.discountValue = discountValue;
	}
	public Promotion(int id, String promocode, String discountValue) {
		super();
		this.id = id;
		Promocode = promocode;
		this.discountValue = discountValue;
	}
	public Promotion() {
		super();
	}
	@Override
	public String toString() {
		return "Promotion [id=" + id + ", Promocode=" + Promocode + ", discountValue=" + discountValue + "]";
	}
	
	
	

}
