package com.pms.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Feedback {
	@Id
	public int user_id;
	public LocalDate Date;
	public LocalTime Time;
	public String textfee;
	
	
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
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	public String getTextfee() {
		return textfee;
	}
	public void setTextfee(String textfee) {
		this.textfee = textfee;
	}
	
	
	public Feedback() {
		super();
	}
	public Feedback(int user_id, LocalDate date, LocalTime time, String textfee) {
		super();
		this.user_id = user_id;
		Date = date;
		Time = time;
		this.textfee = textfee;
	}
	@Override
	public String toString() {
		return "Feedback [user_id=" + user_id + ", Date=" + Date + ", Time=" + Time + ", textfee=" + textfee + "]";
	}
	
	
	
	

}
