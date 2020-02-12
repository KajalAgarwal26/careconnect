package com.ing.careconnect.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.ing.careconnect.dto.UserSlotRequestDto;
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
	
	@Before
	public void setUp() {
		
	}
	
	@Test
	public void userSlot() {
		Bookings booking = new Bookings();
		booking.setDoctorId(1L);	
		booking.setSlots("10:30");
		
		UserSlotRequestDto userSlotRequestDto = new UserSlotRequestDto();
		userSlotRequestDto.setFirstName("fName");
		userSlotRequestDto.setLastName("lName");
		userSlotRequestDto.setDoctorId(1L);
		userSlotRequestDto.setMobile(123456789L);
		
		Users user = new Users();
		//user.setUserId(lL);
		
		Mockito.when(bookingRepository.findBySlotsAndDoctorId("10:30", 1L)).thenReturn(booking);
		Mockito.when(userRepository.save(user)).thenReturn(user);
		
		
	}
}
