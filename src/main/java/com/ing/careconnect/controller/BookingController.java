package com.ing.careconnect.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.careconnect.dto.UserSlotRequestDto;
import com.ing.careconnect.dto.UserSlotResponseDto;
import com.ing.careconnect.service.BookingService;


/**
 *   @author Shankar
 * 
 *   This class is used for to slot booking by the user
 * 
 */

@RestController
@RequestMapping("/booking")
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class BookingController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BookingController.class);
	@Autowired
	BookingService bookingService;
	
	/**
	 * This method is used to booking the available slot 
	 * 
	 * @param UserSlotRequestDto 
	 * @return UserSlotResponseDto
	 */
	
	
	@PostMapping("/userSlotBook")
	public ResponseEntity<UserSlotResponseDto> createUserSlot(@RequestBody UserSlotRequestDto userSlotRequestDto)
	{
		 LOGGER.debug("Inside BookingController :: slot Booking");	
		UserSlotResponseDto userSlotResponseDto=bookingService.userSlot(userSlotRequestDto);
		
		return new ResponseEntity<>(userSlotResponseDto,HttpStatus.OK);
	}
	

}
