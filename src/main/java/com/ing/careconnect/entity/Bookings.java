package com.ing.careconnect.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bookings")
public class Bookings {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bookingId;
	private Long doctorId;
	private String date;
	private String slots;
	private Long userId;
	public Long getBookingId() {
		return bookingId;
	}
	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}
	public Long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getSlots() {
		return slots;
	}
	public void setSlots(String slots) {
		this.slots = slots;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Bookings [bookingId=" + bookingId + ", doctorId=" + doctorId + ", date=" + date + ", slots=" + slots
				+ ", userId=" + userId + "]";
	}
	public Bookings(Long bookingId, Long doctorId, String date, String slots, Long userId) {
		super();
		this.bookingId = bookingId;
		this.doctorId = doctorId;
		this.date = date;
		this.slots = slots;
		this.userId = userId;
	}
	public Bookings() {
		super();
	}
	
	
}
