package com.ing.careconnect.service;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.careconnect.constant.CareConnectConstant;
import com.ing.careconnect.dto.UserSlotRequestDto;
import com.ing.careconnect.dto.UserSlotResponseDto;
import com.ing.careconnect.entity.Bookings;
import com.ing.careconnect.entity.Users;
import com.ing.careconnect.repository.BookingRepository;
import com.ing.careconnect.repository.UserRepository;

/**
 * @author Shankar
 * 
 *         This class used to book the slot time by the user
 * 
 */

@Service
public class BookingServiceImpl implements BookingService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	UserRepository userRepository;

	/**
	 * @author Shankar
	 *
	 *         Method is used to book the available slot. if success it will return
	 *         success else it will return failed message
	 * 
	 *
	 * @param UserSlotRequestDto
	 * @return UserSlotResponseDto
	 */

	@Override
	public UserSlotResponseDto userSlot(UserSlotRequestDto userSlotRequestDto) {
		LOGGER.debug("Inside BookingService :: bookingService");
		Bookings booking = bookingRepository.findBySlotsAndDoctorId(userSlotRequestDto.getSlot(),
				userSlotRequestDto.getDoctorId());
		Users user = new Users();
		user.setFirstName(userSlotRequestDto.getFirstName());
		user.setLastName(userSlotRequestDto.getLastName());
		user.setEmail(userSlotRequestDto.getEmail());
		user.setMobile(userSlotRequestDto.getMobile());
		user.setPassword("12345");
		user.setType("user");
		userRepository.save(user);
		booking.setUserId(user.getUserId());
		booking.setUserName(user.getFirstName() + user.getLastName());
		booking.setBookingDate(LocalDate.now().toString());
		bookingRepository.save(booking);
		UserSlotResponseDto userSlotResponseDto = new UserSlotResponseDto();
		userSlotResponseDto.setBookingId(booking.getBookingId());
		userSlotResponseDto.setMessage(CareConnectConstant.SUCCESS_SLOT_BOOKING);
		return userSlotResponseDto;
	}

}
