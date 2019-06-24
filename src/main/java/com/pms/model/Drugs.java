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
	protected String genericName;
	protected String description;
	protected double price;
	protected String availability;
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
	public String getGenericName() {
		return genericName;
	}
	public void setGenericName(String genericName) {
		this.genericName = genericName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	public Drugs(int id, String name, String genericName, String description, double price, String availability) {
		super();
		this.id = id;
		this.name = name;
		this.genericName = genericName;
		this.description = description;
		this.price = price;
		this.availability = availability;
	}
	public Drugs() {
		super();
	}
	@Override
	public String toString() {
		return "Drugs [id=" + id + ", name=" + name + ", genericName=" + genericName + ", description=" + description
				+ ", price=" + price + ", availability=" + availability + "]";
	}
	
	
}
