package com.ing.careconnect.service;

import java.util.List;

import com.ing.careconnect.dto.AllDoctorsDTO;
import com.ing.careconnect.dto.DoctorsResponseDto;
import com.ing.careconnect.dto.ResponseDto;
import com.ing.careconnect.dto.SearchResponseDto;
import com.ing.careconnect.dto.SlotRequestDto;

public interface DoctorService {

	DoctorsResponseDto getBookedSlots(Long doctorId);

	ResponseDto blockSlots(Long doctorId, SlotRequestDto slotRequestDto);
	
	List<SearchResponseDto> getAllDoctorsBySearchCreiteria(String location, String categery, String specialist);

	AllDoctorsDTO getAllDoctors();
}
