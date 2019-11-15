package com.pms.model;

import java.time.LocalDate;
import java.time.LocalTime;

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
	public LocalDate Date;
	public LocalTime Time;
	

	

	public LocalDate getDate() {
		return Date;
	}
	public void setDate(LocalDate date) {
		Date = date;
	}
	public LocalTime getTime() {
		return Time;
	}
	public void setTime(LocalTime time) {
		Time = time;
	}
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

	public Sales() {
		super();
	}
	public Sales(int id, int pid, String price, LocalDate date, LocalTime time) {
		super();
		this.id = id;
		this.pid = pid;
		this.price = price;
		Date = date;
		Time = time;
	}
	@Override
	public String toString() {
		return "Sales [id=" + id + ", pid=" + pid + ", price=" + price + ", Date=" + Date + ", Time=" + Time + "]";
	}
	
	
	
	
	

	
	


}
