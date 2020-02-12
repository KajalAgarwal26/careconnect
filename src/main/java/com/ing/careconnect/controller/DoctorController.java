package com.ing.careconnect.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ing.careconnect.dto.DoctorsResponseDto;
import com.ing.careconnect.service.DoctorService;

@RestController
@CrossOrigin(allowedHeaders = {"*","*/"}, origins = {"*","*/"})
public class DoctorController {
	
	@Autowired
	DoctorService doctorService;
	@GetMapping("/bookedslots/{doctorId}")
	public ResponseEntity<DoctorsResponseDto> getBookedSlots(@PathVariable("doctorId") Long doctorId)
	{
		DoctorsResponseDto doctorResp = doctorService.getBookedSlots(doctorId);
		return new ResponseEntity<>(doctorResp,HttpStatus.OK);
	}

}
