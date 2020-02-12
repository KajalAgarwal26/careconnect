package com.ing.careconnect.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.careconnect.dto.AllDoctorsDTO;
import com.ing.careconnect.dto.DoctorsResponseDto;
import com.ing.careconnect.dto.ResponseDto;
import com.ing.careconnect.dto.SearchResponseDto;
import com.ing.careconnect.dto.SlotRequestDto;
import com.ing.careconnect.service.DoctorService;

@RestController
@RequestMapping("/doctors")
@CrossOrigin(allowedHeaders = {"*","*/"}, origins = {"*","*/"})
public class DoctorController {
	
	@Autowired
	DoctorService doctorService;
	
	/**
	 * API to get the doctors info by doctorId 
	 * 
	 * @param 	doctorId
	 * @return 	DoctorsResponseDto
	 */
	@GetMapping("/bookedslots/{doctorId}")
	public ResponseEntity<DoctorsResponseDto> getBookedSlots(@PathVariable("doctorId") Long doctorId)
	{
		DoctorsResponseDto doctorResp = doctorService.getBookedSlots(doctorId);
		return new ResponseEntity<>(doctorResp,HttpStatus.OK);
	}
	/**
	 * API to get the list of doctors 
	 * 
	 * @return 	AllDoctorsDTO contains list of doctors
	 */
	@GetMapping("/allDoctors")
	public ResponseEntity<AllDoctorsDTO> getAllDoctors()
	{
		AllDoctorsDTO searchResponse = doctorService.getAllDoctors();
		return new ResponseEntity<>(searchResponse,HttpStatus.OK);
	}
	/**
	 * API to show the search results by passing categery location specialist
	 * 
	 * @param 	doctorId
	 * @return 	DoctorsResponseDto
	 */
	@GetMapping("/searchdoctors/{location}/{categery}/{specialist}")
	public ResponseEntity<List<SearchResponseDto>> getAllDoctorsBySearch(@PathVariable("location") String location,@PathVariable("categery") String categery,@PathVariable("specialist") String specialist )
	{
		List<SearchResponseDto> searchResponse = doctorService.getAllDoctorsBySearchCreiteria(location,categery,specialist);
		return new ResponseEntity<>(searchResponse,HttpStatus.OK);
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
