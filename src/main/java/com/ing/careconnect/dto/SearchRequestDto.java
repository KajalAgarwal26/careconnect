package com.ing.careconnect.dto;

import java.io.Serializable;

public class SearchRequestDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String location;
	private String categery;
	private String specialist;
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCategery() {
		return categery;
	}
	public void setCategery(String categery) {
		this.categery = categery;
	}
	public String getSpecialist() {
		return specialist;
	}
	public void setSpecialist(String specialist) {
		this.specialist = specialist;
	}
	

}
