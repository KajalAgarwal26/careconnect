package com.ing.careconnect.service;

import com.ing.careconnect.dto.DoctorsResponseDto;
import com.ing.careconnect.dto.ResponseDto;
import com.ing.careconnect.dto.SlotRequestDto;

public interface DoctorService {

	DoctorsResponseDto getBookedSlots(Long doctorId);

	ResponseDto blockSlots(Long doctorId, SlotRequestDto slotRequestDto);
	
}
