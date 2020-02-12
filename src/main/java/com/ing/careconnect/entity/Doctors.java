package com.ing.careconnect.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "doctors")
public class Doctors {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long doctorId;
	private String location;
	private String categery;
	private String specialist;
	private String rating;
	private Long userId;
	public Long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
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
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Doctors [doctorId=" + doctorId + ", location=" + location + ", categery=" + categery + ", specialist="
				+ specialist + ", rating=" + rating + ", userId=" + userId + "]";
	}
	public Doctors(Long doctorId, String location, String categery, String specialist, String rating, Long userId) {
		super();
		this.doctorId = doctorId;
		this.location = location;
		this.categery = categery;
		this.specialist = specialist;
		this.rating = rating;
		this.userId = userId;
	}
	public Doctors() {
		super();
	}
	
	
}
