package com.ing.careconnect.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.ing.careconnect.dto.ResponseDto;
import com.ing.careconnect.dto.SlotRequestDto;
import com.ing.careconnect.repository.BookingRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class DoctorServiceImplTest {
	
	@InjectMocks
	DoctorServiceImpl doctorServiceImpl;
	
	@Mock
	BookingRepository bookingRepository;
	
	
	SlotRequestDto slotRequestDto = new SlotRequestDto();
	ResponseDto responseDto = new ResponseDto();
	
	@Before
	public void setUp() {
		slotRequestDto.setBlockDate("2020-02-12");
		slotRequestDto.setFromTime("10:30");
		slotRequestDto.setToTime("12:30");	
		
		responseDto.setMessage("Success");
		responseDto.setStatusCode(200);
	}
	
	@Test
	public void blockSlotsTest() {
		Mockito.when(bookingRepository.saveAll(Mockito.any())).thenReturn(null);
		responseDto = doctorServiceImpl.blockSlots(1L, slotRequestDto);		
		assertEquals("Success", responseDto.getMessage());		
	}
}
