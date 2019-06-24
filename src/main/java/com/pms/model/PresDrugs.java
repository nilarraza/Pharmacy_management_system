package com.pms.model;

import javax.persistence.Entity;

@Entity
public class PresDrugs extends Drugs {
	
	private String dosage;

	public String getDosage() {
		return dosage;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	public PresDrugs(int id, String name, String genericName, String decription, double price, String availability,
			String dosage) {
		super(id, name, genericName, decription, price, availability);
		this.dosage = dosage;
	}

	public PresDrugs() {
		super();
	}

	@Override
	public String toString() {
		return "PresDrugs [dosage=" + dosage + "]";
	}
	
	

	

}
