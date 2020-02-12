package com.ing.careconnect.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import com.ing.careconnect.entity.Bookings;
import com.ing.careconnect.entity.Doctors;

public class DoctorsResponseDto implements Serializable {
	
	private static final long serialVersionUID = 1905122041950251207L;
	private String message;
	private Integer statusCode;
	private transient List<Bookings> booking;
	private transient Optional<Doctors> doctors;
	public Optional<Doctors> getDoctors() {
		return doctors;
	}
	public void setDoctors(Optional<Doctors> doctors) {
		this.doctors = doctors;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public List<Bookings> getBooking() {
		return booking;
	}
	public void setBooking(List<Bookings> booking) {
		this.booking = booking;
	}
	
	
	
	
}
