package com.ing.careconnect.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.careconnect.dto.BookingRequestDto;
import com.ing.careconnect.service.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingController {
	@Autowired
	BookingService bookingService;
	
	@PostMapping("/placeOrder")
	public ResponseEntity placeOrder(@RequestBody BookingRequestDto bookingRequestDto)
	{
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
