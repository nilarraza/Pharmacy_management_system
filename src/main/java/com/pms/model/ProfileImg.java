package com.pms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ProfileImg {
	@Id
	public int id;
	public String url;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public ProfileImg(int id, String url) {
		super();
		this.id = id;
		this.url = url;
	}
	public ProfileImg() {
		super();
	}
	@Override
	public String toString() {
		return "ProfileImg [id=" + id + ", url=" + url + "]";
	}
	
	
	

}
