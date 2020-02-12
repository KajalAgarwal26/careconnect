package com.ing.careconnect.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.careconnect.dto.DoctorsResponseDto;
import com.ing.careconnect.entity.Bookings;
import com.ing.careconnect.entity.Doctors;
import com.ing.careconnect.exception.DoctorNotAvailableException;
import com.ing.careconnect.repository.BookingRepository;
import com.ing.careconnect.repository.DoctorRepository;
import com.ing.careconnect.util.CareConnectUtil;

@Service
public class  DoctorServiceImpl implements DoctorService{

	@Autowired
	DoctorRepository  doctorRepository; 
	
	@Autowired
	BookingRepository bookingRepository;
	
	@Override
	public DoctorsResponseDto getBookedSlots(Long doctorId) {
		DoctorsResponseDto doctorsResponseDto=new DoctorsResponseDto();
		Optional<Doctors> doctorResp = doctorRepository.findById(doctorId);
		if(!doctorResp.isPresent()) {
			throw new DoctorNotAvailableException(CareConnectUtil.DOCTOR_NOT_AVAILABLE);
		}
		Long doctorId1 = doctorResp.get().getDoctorId();
		
		List<Bookings> bookingResp = bookingRepository.findByDoctorId(doctorId1);
		
		doctorsResponseDto.setMessage("success");
		doctorsResponseDto.setStatusCode(200);;
		doctorsResponseDto.setBooking(bookingResp);
		
		doctorsResponseDto.setDoctors(doctorResp);
		
		return doctorsResponseDto;
	}

}
