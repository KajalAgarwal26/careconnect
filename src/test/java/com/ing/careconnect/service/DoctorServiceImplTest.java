package com.ing.careconnect.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.ing.careconnect.dto.AllDoctorsDTO;
import com.ing.careconnect.dto.DoctorsResponseDto;
import com.ing.careconnect.dto.ResponseDto;
import com.ing.careconnect.dto.SlotRequestDto;
import com.ing.careconnect.entity.Bookings;
import com.ing.careconnect.entity.Doctors;
import com.ing.careconnect.exception.DoctorNotAvailableException;
import com.ing.careconnect.repository.BookingRepository;
import com.ing.careconnect.repository.DoctorRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class DoctorServiceImplTest {
	
	@InjectMocks
	DoctorServiceImpl doctorServiceImpl;
	
	@Mock
	BookingRepository bookingRepository;
	
	@Mock
	DoctorRepository doctorRepository;
	
	
	SlotRequestDto slotRequestDto = new SlotRequestDto();
	ResponseDto responseDto = new ResponseDto();
	DoctorsResponseDto doctorsResponseDto = new DoctorsResponseDto();
	AllDoctorsDTO allDoctorsDTO = new AllDoctorsDTO();
	
	List<Doctors> doctorList = null;
	Doctors doctor = null;
	Optional<Doctors> doctorOpt = null;	
	List<Bookings> bookingList = null;	
	
	static final String SUCCESS = "Success";
	
	@Before
	public void setUp() {
		slotRequestDto.setBlockDate("2020-02-12");
		slotRequestDto.setFromTime("10:30");
		slotRequestDto.setToTime("12:30");	
		
		responseDto.setMessage(SUCCESS);
		responseDto.setStatusCode(200);
				
		doctor = new Doctors();
		doctor.setDoctorId(1L);
		doctor.setRating("5");
		doctorOpt = Optional.of(doctor);
		
		Bookings bookings = new Bookings();
		bookings.setDoctorId(1L);
		
		bookingList = new ArrayList<>();		
		bookingList.add(bookings);
		
		doctorsResponseDto.setBooking(bookingList);
		doctorsResponseDto.setDoctors(doctorOpt);
		doctorsResponseDto.setMessage(SUCCESS);
		
		doctorList = new ArrayList<>();
		doctorList.add(doctor);
		allDoctorsDTO.setDoctors(doctorList);
	}
	
	@Test
	public void blockSlotsTest() {
		Mockito.when(bookingRepository.saveAll(Mockito.any())).thenReturn(null);
		responseDto = doctorServiceImpl.blockSlots(1L, slotRequestDto);		
		assertEquals(SUCCESS, responseDto.getMessage());		
	}
	
	@Test
	public void getBookedSlotsTest() {
		Mockito.when(doctorRepository.findById(1L)).thenReturn(doctorOpt);
		Mockito.when(bookingRepository.findByDoctorId(1L)).thenReturn(bookingList);
		doctorsResponseDto = doctorServiceImpl.getBookedSlots(1L);		
		assertEquals(SUCCESS, responseDto.getMessage());		
	}
	
	@Test(expected=DoctorNotAvailableException.class)
	public void getBookedSlotsTestException() {
		Mockito.when(doctorRepository.findById(1L)).thenReturn(doctorOpt);
		Mockito.when(bookingRepository.findByDoctorId(1L)).thenReturn(bookingList);
	}
	
	@Test
	public void getAllDoctorsTest() {
		Mockito.when(doctorRepository.findAll()).thenReturn(doctorList);
		allDoctorsDTO = doctorServiceImpl.getAllDoctors();		
		assertEquals(1, allDoctorsDTO.getDoctors().size());		
	}
}
