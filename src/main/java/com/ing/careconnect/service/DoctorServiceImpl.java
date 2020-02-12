package com.ing.careconnect.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.careconnect.dto.DoctorsResponseDto;
import com.ing.careconnect.dto.ResponseDto;
import com.ing.careconnect.dto.SlotRequestDto;
import com.ing.careconnect.entity.Bookings;
import com.ing.careconnect.entity.Doctors;
import com.ing.careconnect.exception.DoctorNotAvailableException;
import com.ing.careconnect.repository.BookingRepository;
import com.ing.careconnect.repository.DoctorRepository;
import com.ing.careconnect.util.CareConnectUtil;

@Service
public class  DoctorServiceImpl implements DoctorService{

	public static final String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";

	public static final String HOURS = "HOURS";

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

	
	@Override
	public ResponseDto blockSlots(Long doctorId, SlotRequestDto slotRequestDto) {				
		
		List<Bookings> bookingList = new ArrayList<>();
		ResponseDto responseDto = new ResponseDto();
		String fromDateTime = slotRequestDto.getDate() +" "+ slotRequestDto.getFromTime();
		String toDateTime = slotRequestDto.getDate() +" "+ slotRequestDto.getToTime();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(YYYY_MM_DD_HH_MM);
		LocalDateTime dateFirst = LocalDateTime.parse(fromDateTime, formatter);
		LocalDateTime dateLast = LocalDateTime.parse(toDateTime, formatter);		
		
		final ChronoUnit unit = ChronoUnit.valueOf(HOURS);
		for (LocalDateTime dateBetween = dateFirst; !dateBetween.isAfter(dateLast); dateBetween = dateBetween
				.plus(Duration.of(1, unit))) {			
			//Create Booking entity.
			Bookings booking = new Bookings();
			booking.setDoctorId(doctorId);
			booking.setDate(slotRequestDto.getDate());
			String[] slipSlots = dateBetween.format(formatter).split(" ");
			booking.setSlots(slipSlots[1]);
			bookingList.add(booking);			
		}		
		if(!bookingList.isEmpty()) {
			bookingRepository.saveAll(bookingList);				
		} 		
		responseDto.setMessage("Success");
		responseDto.setStatusCode(200);		
		return responseDto;
	}	
}
