package com.ing.careconnect.exception;

public class DoctorNotAvailableException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private final String message;
	
	public DoctorNotAvailableException(String message) {
		super(message);
		this.message=message;
	}

}
