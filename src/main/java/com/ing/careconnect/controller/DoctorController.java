package com.ing.careconnect.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ing.careconnect.dto.DoctorsResponseDto;
import com.ing.careconnect.dto.ResponseDto;
import com.ing.careconnect.dto.SlotRequestDto;
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
	
	/**
	 * API to block slots by doctors. 
	 * 
	 * @param 	doctorId
	 * @param 	slotRequestDto		Will pass date, fromTime and toTime.
	 * @return 	responseDto			Will return success code.
	 */
	@PostMapping("/{doctorId}/slotdetails")
	public ResponseEntity<ResponseDto> saveVendorItemDetails(@PathVariable("doctorId") Long doctorId, @RequestBody SlotRequestDto slotRequestDto)  {
		ResponseDto responseDto = doctorService.blockSlots(doctorId, slotRequestDto);
		return ResponseEntity.ok().body(responseDto);
	}

}
