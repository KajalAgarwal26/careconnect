package com.ing.careconnect.service;

import com.ing.careconnect.dto.DoctorsResponseDto;

public interface DoctorService {

	DoctorsResponseDto getBookedSlots(Long doctorId);

}
