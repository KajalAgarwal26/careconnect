package com.ing.careconnect.dto;

import java.io.Serializable;
import java.util.List;

import com.ing.careconnect.entity.Doctors;

public class AllDoctorsDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private transient List<Doctors> doctors;

	public List<Doctors> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctors> doctors) {
		this.doctors = doctors;
	}

}
