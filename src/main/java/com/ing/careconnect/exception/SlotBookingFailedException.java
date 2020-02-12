package com.ing.careconnect.exception;

public class SlotBookingFailedException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private final String message;
	public SlotBookingFailedException (String message) {
		super(message);
		this.message=message;
	}
	
}
