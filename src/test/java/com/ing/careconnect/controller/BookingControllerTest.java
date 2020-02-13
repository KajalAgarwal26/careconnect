package com.ing.careconnect.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.ing.careconnect.dto.UserSlotRequestDto;
import com.ing.careconnect.dto.UserSlotResponseDto;
import com.ing.careconnect.service.BookingService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class BookingControllerTest {

	@InjectMocks
	BookingController bookingController;

	@Mock
	BookingService bookingService;

	UserSlotRequestDto userSlotRequestDto = new UserSlotRequestDto();
	UserSlotResponseDto userSlotResponseDto = new UserSlotResponseDto();

	@Before
	public void setUp() {
		userSlotRequestDto.setDoctorId(1L);
		userSlotRequestDto.setEmail("Shankar.sft93@gmail.com");
		userSlotRequestDto.setFirstName("Shankar");
		userSlotRequestDto.setLastName("Kavi");
		userSlotRequestDto.setMobile(9952074514L);
		userSlotRequestDto.setSlot("10:30");
		userSlotResponseDto.setBookingId(2L);
		userSlotResponseDto.setMessage("Success");
	}

	@Test
	public void testGetBookingDoctors() {
		Mockito.when(bookingService.userSlot(userSlotRequestDto)).thenReturn(userSlotResponseDto);
		ResponseEntity<UserSlotResponseDto> userSlotResponse = bookingController.createUserSlot(userSlotRequestDto);
		Assert.assertNotNull(userSlotResponse);
		Assert.assertEquals(200, userSlotResponse.getStatusCode().value());
	}
}
