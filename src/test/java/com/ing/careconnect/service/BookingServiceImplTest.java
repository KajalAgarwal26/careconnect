package com.ing.careconnect.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.ing.careconnect.dto.UserSlotRequestDto;
import com.ing.careconnect.dto.UserSlotResponseDto;
import com.ing.careconnect.entity.Bookings;
import com.ing.careconnect.entity.Users;
import com.ing.careconnect.repository.BookingRepository;
import com.ing.careconnect.repository.UserRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class BookingServiceImplTest {
	


	@InjectMocks
	BookingServiceImpl bookingServiceImpl;
	
	@Mock
	BookingRepository bookingRepository;
	
	@Mock
	UserRepository userRepository;
	
	@Test
	public void blockSlotsTest() {
		UserSlotRequestDto userSlotRequestDto=new UserSlotRequestDto();
		userSlotRequestDto.setSlot("10:30");
		userSlotRequestDto.getDoctorId();
		UserSlotResponseDto userSlotResponseDto=new UserSlotResponseDto();
		userSlotResponseDto.setMessage("success");
		Bookings booking=new Bookings();
		Users user = new Users();
		user.setFirstName("Rajesh");
		user.setLastName("Bojja");
		user.setEmail("rajesh@gmail.com");
		user.setMobile(8923659L);
		user.setPassword("12345");
		user.setType("user");
		user.setUserId(1L);
		booking.setBookingId(1L);
		booking.setUserId(2L);
		booking.setUserName("Rajesh");
		booking.setBookingDate(LocalDate.now().toString());
		
		Mockito.when(bookingRepository.findBySlotsAndDoctorId(userSlotRequestDto.getSlot(), userSlotRequestDto.getDoctorId())).thenReturn(booking);
		Mockito.when(userRepository.save(user)).thenReturn(user);
		Mockito.when(bookingRepository.save(booking)).thenReturn(null);
		
		
		UserSlotResponseDto userSlot = bookingServiceImpl.userSlot(userSlotRequestDto);
		
		assertEquals("Slot Booking Success", userSlot.getMessage());
	}
	
	
}
