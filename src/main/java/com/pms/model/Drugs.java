package com.pms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Drugs {
	@Id
	@GeneratedValue
	protected int id;
	protected String name;
	protected String price;
	protected String description;
	protected String availability;
	protected String url;
	
	
	public Drugs() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getAvailability() {
		return availability;
	}


	public void setAvailability(String availability) {
		this.availability = availability;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	@Override
	public String toString() {
		return "Drugs [id=" + id + ", name=" + name + ", price=" + price + ", description=" + description
				+ ", availability=" + availability + ", url=" + url + "]";
	}


	public Drugs(int id, String name, String price, String description, String availability, String url) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.availability = availability;
		this.url = url;
	}


}
