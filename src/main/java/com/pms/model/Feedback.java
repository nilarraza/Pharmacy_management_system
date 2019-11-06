package com.pms.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Feedback {
	@Id
	public int user_id;
	
	public String textfee;
	
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
	
	public Feedback(int user_id, String textfee) {
		super();
		this.user_id = user_id;
		this.textfee = textfee;
	}
	public Feedback() {
		super();
	}
	@Override
	public String toString() {
		return "Feedback [user_id=" + user_id + ", textfee=" + textfee + "]";
	}
	
	
	

}
